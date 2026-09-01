#!/bin/bash

# CubeWorld APK Build Script
# Minecraft Bedrock tarzı oyun

echo "======================================"
echo "🎮 CubeWorld APK Build Başlıyor..."
echo "======================================"

# Renkli çıktı için
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

cd luanti-master/android

# 1. Gradle cache temizle (isteğe bağlı)
echo -e "${YELLOW}[1/5] Gradle temizleniyor...${NC}"
./gradlew clean

# 2. Dependencies indir
echo -e "${YELLOW}[2/5] Bağımlılıklar indiriliyor...${NC}"
./gradlew getDeps

# 3. Debug APK derle (Test için)
echo -e "${YELLOW}[3/5] Debug APK derleniyor...${NC}"
./gradlew assembleDebug

# 4. Release APK derle (Yayın için)
echo -e "${YELLOW}[4/5] Release APK derleniyor...${NC}"
./gradlew assembleRelease

# 5. Dosyaları kopyala
echo -e "${YELLOW}[5/5] APK dosyaları hazırlanıyor...${NC}"
mkdir -p ../build_output
cp app/build/outputs/apk/release/*.apk ../build_output/
cp app/build/outputs/apk/debug/*.apk ../build_output/

echo ""
echo -e "${GREEN}======================================"
echo "✅ APK Derleme Tamamlandı!"
echo "=====================================${NC}"
echo ""
echo "📱 APK Dosyaları:"
ls -lh ../build_output/*.apk
echo ""
echo "🔗 İndirme yolu: ./build_output/"
echo ""
echo "📲 Telefonda kurmak için:"
echo "   adb install -r build_output/CubeWorld-release.apk"
echo ""
