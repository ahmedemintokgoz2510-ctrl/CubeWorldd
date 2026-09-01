package net.minetest.minetest;

/**
 * Minecraft Bedrock Tarzı Kontrol Sistemi
 * CubeWorld için özel geliştirilmiş kontrol mekaniklerine
 */
public class BedrockControls {

    // Hareket Kontrolleri
    public static final int KEY_FORWARD = 1;  // W
    public static final int KEY_BACKWARD = 2; // S
    public static final int KEY_LEFT = 3;     // A
    public static final int KEY_RIGHT = 4;    // D

    // Eylem Kontrolleri
    public static final int KEY_JUMP = 5;     // SPACE
    public static final int KEY_SNEAK = 6;    // SHIFT
    public static final int KEY_DIG = 7;      // Sol Tık / Touch
    public static final int KEY_PLACE = 8;    // Sağ Tık / Touch
    public static final int KEY_INVENTORY = 9; // E
    public static final int KEY_DROP = 10;    // Q

    // Oyun Kontrolleri
    public static final int KEY_PAUSE = 11;   // ESC
    public static final int KEY_CHAT = 12;    // T
    public static final int KEY_SPRINT = 13;  // CTRL

    // Kamera Kontrolleri (Dokunmatik)
    public static final int TOUCH_LOOK = 14;     // Sağ taraf dokunma
    public static final int TOUCH_MOVE = 15;     // Sol taraf joystick

    /**
     * Minecraft Bedrock Tarzı Kontrol Şeması
     * Mobil Cihazlar için Optimize Edilmiş
     */
    public static String getControlDescription() {
        return "CubeWorld - Minecraft Bedrock Kontrolleri\n\n" +
               "HAREKET:\n" +
               "  W - İleri Git\n" +
               "  S - Geri Git\n" +
               "  A - Sol Git\n" +
               "  D - Sağ Git\n\n" +
               "EYLEMLER:\n" +
               "  SPACE - Zıpla\n" +
               "  SHIFT - Eğil\n" +
               "  Sol Tık - Blok Kır / Vur\n" +
               "  Sağ Tık - Blok Koy / Kullan\n" +
               "  E - Envanter Aç\n" +
               "  Q - Eşya Bırak\n" +
               "  CTRL - Hızlı Koş\n\n" +
               "OYUN:\n" +
               "  ESC - Durdur / Menü\n" +
               "  T - Sohbet Aç\n" +
               "  Fare - Bakış Yönü Değiştir\n";
    }

    /**
     * Dokunmatik Ekran Kontrolü
     * Mobil cihazlarda iki joystick sistemi
     */
    public static class TouchControls {
        // Sol Joystick - Hareket
        public float leftStickX = 0f;  // -1.0 (sol) to 1.0 (sağ)
        public float leftStickY = 0f;  // -1.0 (ileri) to 1.0 (geri)

        // Sağ Joystick - Bakış
        public float rightStickX = 0f; // -1.0 (sol) to 1.0 (sağ)
        public float rightStickY = 0f; // -1.0 (yukarı) to 1.0 (aşağı)

        // Düğmeler
        public boolean jumpPressed = false;
        public boolean digPressed = false;
        public boolean placePressed = false;
        public boolean sneakPressed = false;
        public boolean inventoryPressed = false;
    }

    /**
     * Kontrolü İşle
     */
    public static void processControl(int keyCode, boolean isPressed) {
        switch (keyCode) {
            case KEY_FORWARD:
                // İleri git
                break;
            case KEY_BACKWARD:
                // Geri git
                break;
            case KEY_LEFT:
                // Sol git
                break;
            case KEY_RIGHT:
                // Sağ git
                break;
            case KEY_JUMP:
                // Zıpla
                break;
            case KEY_DIG:
                // Blok kır
                break;
            case KEY_PLACE:
                // Blok koy
                break;
            case KEY_INVENTORY:
                // Envanter aç
                break;
        }
    }
}
