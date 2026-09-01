````markdown name=README.md url=https://github.com/ahmedemintokgoz2510-ctrl/CubeWorldd

<div align="center">
    <h1>🎮 CubeWorld</h1>
    <p><strong>Minecraft Bedrock Tarzı Sandbox Oyunu</strong></p>
    <p>Zodiac Games tarafından geliştirilmiştir</p>
</div>

---

## 📋 Hakkında

**CubeWorld**, Minecraft Bedrock oyun mekaniklerine dayanan, Luanti motorunu temel alan açık kaynak bir sandbox oyunudur. Zodiac Games tarafından özel olarak geliştirilmiş mobil oyundur.

Sınırsız blok dünyasında:
- 🏗️ Milyonlarca blok ile inşa et
- 🎨 Hayal ettiğin her şeyi yarat
- 👥 Arkadaşlarınla oyna (Multiplayer)
- ⚡ Smooth Minecraft Bedrock kontrolleri
- 📱 Mobil cihazlarda optimize edilmiş

---

## 🚀 Hızlı Başlangıç

### İndirme

**[📥 En Son APK İndir](https://github.com/ahmedemintokgoz2510-ctrl/CubeWorldd/releases/latest)**

### Kurulum

1. APK dosyasını telefona yükle
2. Bilinmeyen kaynaklardan kuruluma izin ver:
   - Ayarlar → Güvenlik → Bilinmeyen Kaynaklar
3. Yükle ve oyna! 🎮

---

## ✨ Özellikler

| Özellik | Açıklama |
|---------|----------|
| 🌍 **Sınırsız Dünya** | Devasa açık dünyada keşif yap |
| ⌨️ **Minecraft Kontrolleri** | WASD + Mouse + Dokunmatik desteği |
| 👥 **Multiplayer** | Arkadaşlarınla çok oyunculu oyna |
| 🤝 **Arkadaş Sistemi** | Arkadaş listesi & davet sistemi |
| 🎮 **Iki Mod** | Survival & Creative modları |
| 📱 **Mobil Optimizasyon** | Android 5.0+ tam desteği |
| 🇹🇷 **Türkçe Dil** | Tam Türkçe arayüz |
| 💻 **Açık Kaynak** | GNU LGPL 2.1 lisansı |

---

## 🎮 Kontroller

### Klavye & Fare

| Kontrol | İşlem |
|---------|-------|
| **W, A, S, D** | Hareket |
| **SPACE** | Zıpla |
| **SHIFT** | Eğil |
| **Sol Tık** | Blok Kır / Vur |
| **Sağ Tık** | Blok Koy / Kullan |
| **E** | Envanter Aç |
| **Q** | Eşya Bırak |
| **CTRL** | Koş |
| **ESC** | Durdur / Menü |
| **T** | Sohbet |
| **Fare Hareketi** | Bakış Yönü |

### Dokunmatik (Mobil)

- **Sol Joystick** - Hareket
- **Sağ Joystick** - Bakış Yönü
- **Düğmeler** - Zıpla, Kır, Koy, Envanteri Aç

---

## 💻 Teknik Bilgiler

### Sistem Gereksinimleri

- **Minimum OS:** Android 5.0 (API 21)
- **Önerilen OS:** Android 8.0+ (API 26+)
- **RAM:** 2GB minimum (4GB önerilir)
- **Depolama:** 150MB boş alan
- **Grafik:** OpenGL ES 2.0+

### Teknik Özellikler

- **Motor:** Luanti (Minetest fork)
- **Programlama Dili:** Java (Android) + Lua (Oyun)
- **Veritabanı:** SQLite
- **API:** REST + Socket
- **Lisans:** GNU LGPL 2.1

---

## 🔧 Geliştirme & Build

### Gereksinimler

```
- Android SDK 30+
- Android NDK 29.0.14206865
- Java 11+
- Gradle 7.5+
- Git
```

### Klonlama

```bash
git clone https://github.com/ahmedemintokgoz2510-ctrl/CubeWorldd.git
cd CubeWorldd
```

### Build APK

```bash
# Debug APK
cd luanti-master/android
./gradlew assembleDebug

# Release APK
./gradlew assembleRelease
```

Veya kullanın otomatik script:

```bash
chmod +x build_apk.sh
./build_apk.sh
```

APK dosyası şurada bulunacak: `app/build/outputs/apk/`

### Proje Yapısı

```
CubeWorldd/
├── luanti-master/              # Luanti Motor kaynağı
│   ├── android/                # Android build dosyaları
│   │   ├── app/                # Android uygulaması
│   │   │   └── src/main/
│   │   │       ├── java/       # Java kodları
│   │   │       └── res/        # Kaynaklar
│   │   └── native/             # C++ Motor kodu
│   └── src/                    # Motor kaynağı
├── build_apk.sh                # Build scripti
├── README.md                   # Bu dosya
└── .gitignore
```

---

## 📱 Android Özel Bilgi

### İzinler

CubeWorld aşağıdaki izinleri kullanır:
- `INTERNET` - Multiplayer & Arkadaşlar
- `WRITE_EXTERNAL_STORAGE` - Oyun Verileri
- `READ_EXTERNAL_STORAGE` - Harita Yükleme

### Performans İpuçları

1. **Render Distance** - Daha az chunk = Daha iyi FPS
2. **Grafik Kalitesi** - Düşük kaliteye geç performans için
3. **Çoklu İşleme** - 4+ Core işlemci önerilir
4. **Bellekleme** - Minimize kapalı iken bellekleme serbest bırakılır

---

## 👥 Arkadaş Sistemi

### Nasıl Çalışır?

1. **Arkadaş Ekle** - Arkadaş ID veya kullanıcı adıyla ara
2. **Davet Gönder** - Oyuna katılmaya davet et
3. **Durum Göster** - Çevrimiçi/Çevrimdışı status
4. **Mesajlaş** - In-game mesajlaşma

### Multiplayer

- **Maksimum Oyuncu:** 32 oyuncu/sunucu
- **Gecikme:** <100ms önerilir
- **Bağlantı:** UDP Socket
- **Sunucu:** Şu anda lokal/LAN

---

## 🐛 Sorunları Bildirme

Bir hata buldum mu?

1. GitHub Issues'e gidin: [Issues](https://github.com/ahmedemintokgoz2510-ctrl/CubeWorldd/issues)
2. Detaylı açıklama yap
3. Cihaz bilgisi & Android versiyonu ekle
4. Hata logları varsa ekle

---

## 📝 Sürüm Tarihi

### v1.0.0 - 2026-09-01

**Zodiac Games tarafından tam yeniden tasarlandı**

- ✅ CubeWorld branding (Zodiac Games)
- ✅ Minecraft Bedrock kontrolleri
- ✅ Arkadaş sistemi altyapısı
- ✅ Hakkında sayfası & Menü
- ✅ APK Build otomasyonu
- ✅ Türkçe dil desteği
- ✅ Multiplayer hazırlığı

---

## 📄 Lisans

Bu proje aşağıda lisanslıdır:

- **CubeWorld Kodu:** GNU LGPL 2.1
- **Luanti Motor:** GNU LGPL 2.1
- **Dış Kütüphaneler:** Lisans bilgisi için kaynak kodu kontrol et

Lisans dosyası: [LICENSE](LICENSE) veya [LGPL 2.1](https://www.gnu.org/licenses/old-licenses/lgpl-2.1.en.html)

---

## 🤝 Katkıda Bulunma

Pull request'leri ve önerileri kabul ediyoruz!

1. Fork edin
2. Feature branch oluşturun (`git checkout -b feature/AmazingFeature`)
3. Değişiklikleri commit edin (`git commit -m 'Add amazing feature'`)
4. Branch'ı push edin (`git push origin feature/AmazingFeature`)
5. Pull Request açın

---

## 📞 İletişim

**Zodiac Games**

- 📧 **GitHub:** [@ahmedemintokgoz2510-ctrl](https://github.com/ahmedemintokgoz2510-ctrl)
- 🔗 **Repository:** [CubeWorldd](https://github.com/ahmedemintokgoz2510-ctrl/CubeWorldd)
- 🌐 **Web:** zodiacgames.studio *(çok yakında)*
- 💬 **Issues:** [GitHub Issues](https://github.com/ahmedemintokgoz2510-ctrl/CubeWorldd/issues)

---

## 📚 Kaynaklar

- [Luanti Resmi Web](https://www.luanti.org/)
- [Luanti Dokümantasyon](https://docs.luanti.org/)
- [Luanti Forum](https://forum.luanti.org/)
- [Luanti GitHub](https://github.com/luanti-org/luanti/)

---

<div align="center">

**✨ CubeWorld - Yaratıl • Keşfet • Oyna ✨**

© 2026 Zodiac Games. Tüm Hakları Saklıdır.

Luanti motorunun GNU LGPL 2.1 lisansını seviyor ve saygı duyuyoruz ❤️

</div>

````
