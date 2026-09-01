package com.ahmedemin.cubeworld.input;

import android.view.MotionEvent;
import android.view.View;

/**
 * Minecraft Bedrock gibi dokunma kontrolü
 * Sol taraf: Hareket (D-Pad)
 * Sağ taraf: Kamera kontrolü (Look Around)
 * Tap: Blok kır (Mine)
 * Tap sağ taraf: Blok koy (Place)
 */
public class TouchInputHandler implements View.OnTouchListener {
    
    private TouchInputListener listener;
    
    // Sol taraf D-Pad
    private static final float DPAD_SIZE = 150f;
    private static final float DPAD_THRESHOLD = 50f;
    
    // Sağ taraf kamera
    private float cameraX = 0;
    private float cameraY = 0;
    private float lastCameraX = 0;
    private float lastCameraY = 0;
    
    // Multi-touch pointers
    private int leftPointerId = -1;
    private int rightPointerId = -1;
    
    public interface TouchInputListener {
        // Hareket
        void onMoveForward(boolean pressed);
        void onMoveBackward(boolean pressed);
        void onMoveLeft(boolean pressed);
        void onMoveRight(boolean pressed);
        void onJump(boolean pressed);
        
        // Kamera
        void onLook(float deltaX, float deltaY);
        
        // Blok işlemleri
        void onAttack(); // Sol tık - Blok kır
        void onUse();    // Sağ tık - Blok koy
        
        // Envanter
        void onInventory();
    }
    
    public TouchInputHandler(TouchInputListener listener) {
        this.listener = listener;
    }
    
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getActionMasked();
        int pointerIndex = event.getActionIndex();
        int pointerId = event.getPointerId(pointerIndex);
        float x = event.getX(pointerIndex);
        float y = event.getY(pointerIndex);
        
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                return handleTouchDown(x, y, pointerId, event.getEventTime());
            case MotionEvent.ACTION_POINTER_DOWN:
                return handlePointerDown(x, y, pointerId, event);
            case MotionEvent.ACTION_MOVE:
                return handleTouchMove(event);
            case MotionEvent.ACTION_POINTER_UP:
                return handlePointerUp(pointerId, event);
            case MotionEvent.ACTION_UP:
                return handleTouchUp(pointerId);
        }
        return false;
    }
    
    private boolean handleTouchDown(float x, float y, int pointerId, long eventTime) {
        // Sol taraf D-Pad kontrolü
        if (x < 200) {
            leftPointerId = pointerId;
            updateDPad(x, y);
            return true;
        }
        // Sağ taraf kamera kontrolü
        else {
            rightPointerId = pointerId;
            lastCameraX = x;
            lastCameraY = y;
            return true;
        }
    }
    
    private boolean handlePointerDown(float x, float y, int pointerId, MotionEvent event) {
        // Sol taraf boş ise bu pointeri ata
        if (leftPointerId == -1 && x < 200) {
            leftPointerId = pointerId;
            updateDPad(x, y);
            return true;
        }
        // Sağ taraf boş ise bu pointeri ata
        else if (rightPointerId == -1 && x >= 200) {
            rightPointerId = pointerId;
            lastCameraX = x;
            lastCameraY = y;
            return true;
        }
        return false;
    }
    
    private boolean handleTouchMove(MotionEvent event) {
        boolean handled = false;
        
        // Sol D-Pad hareketi
        if (leftPointerId != -1) {
            int leftIndex = event.findPointerIndex(leftPointerId);
            if (leftIndex >= 0) {
                float x = event.getX(leftIndex);
                float y = event.getY(leftIndex);
                updateDPad(x, y);
                handled = true;
            }
        }
        
        // Sağ kamera hareketi
        if (rightPointerId != -1) {
            int rightIndex = event.findPointerIndex(rightPointerId);
            if (rightIndex >= 0) {
                float x = event.getX(rightIndex);
                float y = event.getY(rightIndex);
                
                float deltaX = x - lastCameraX;
                float deltaY = y - lastCameraY;
                
                cameraX += deltaX;
                cameraY += deltaY;
                
                if (listener != null) {
                    listener.onLook(deltaX * 0.5f, deltaY * 0.5f); // Hassasiyet kontrolü
                }
                
                lastCameraX = x;
                lastCameraY = y;
                handled = true;
            }
        }
        
        return handled;
    }
    
    private boolean handlePointerUp(int pointerId, MotionEvent event) {
        if (pointerId == leftPointerId) {
            // D-Pad'i sıfırla
            resetDPad();
            leftPointerId = -1;
            return true;
        }
        if (pointerId == rightPointerId) {
            rightPointerId = -1;
            return true;
        }
        return false;
    }
    
    private boolean handleTouchUp(int pointerId) {
        if (pointerId == leftPointerId) {
            resetDPad();
            leftPointerId = -1;
            return true;
        }
        if (pointerId == rightPointerId) {
            rightPointerId = -1;
            return true;
        }
        return false;
    }
    
    /**
     * D-Pad'i güncelle (Sol taraf)
     * İçerik
     *     ^ W
     *   < A S D >
     *     V S
     */
    private void updateDPad(float x, float y) {
        // D-Pad merkezi (sol üst köşe)
        float centerX = 75;
        float centerY = 75;
        
        float dx = x - centerX;
        float dy = y - centerY;
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        
        // Yön hesapla (açıya göre)
        float angle = (float) Math.atan2(dy, dx) * 180 / (float) Math.PI;
        
        // Açıya göre yön belirle (8 yön: 45 derece aralıklar)
        boolean forward = false;
        boolean backward = false;
        boolean left = false;
        boolean right = false;
        
        if (distance > DPAD_THRESHOLD) {
            // Normalize açı
            if (angle < 0) angle += 360;
            
            // İleri (W) - 315-45 derece
            if (angle > 315 || angle < 45) {
                forward = true;
            }
            // Sağ (D) - 315-45 derece
            else if (angle >= 45 && angle < 135) {
                right = true;
            }
            // Geri (S) - 135-225 derece
            else if (angle >= 135 && angle < 225) {
                backward = true;
            }
            // Sol (A) - 225-315 derece
            else if (angle >= 225 && angle < 315) {
                left = true;
            }
            
            // Çapraz yönleri de destekle
            if ((angle > 25 && angle < 65) || (angle > 335 && angle < 355)) {
                // İleri-Sağ
                forward = true;
                right = true;
            } else if ((angle > 115 && angle < 155)) {
                // Geri-Sağ
                backward = true;
                right = true;
            } else if ((angle > 205 && angle < 245)) {
                // Geri-Sol
                backward = true;
                left = true;
            } else if ((angle > 295 && angle < 335)) {
                // İleri-Sol
                forward = true;
                left = true;
            }
        }
        
        // Listener'ı güncelle
        if (listener != null) {
            listener.onMoveForward(forward);
            listener.onMoveBackward(backward);
            listener.onMoveLeft(left);
            listener.onMoveRight(right);
        }
    }
    
    private void resetDPad() {
        if (listener != null) {
            listener.onMoveForward(false);
            listener.onMoveBackward(false);
            listener.onMoveLeft(false);
            listener.onMoveRight(false);
        }
    }
}
