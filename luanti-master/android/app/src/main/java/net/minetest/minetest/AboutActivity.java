package net.minetest.minetest;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Toolbar ayarla
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("CubeWorld Hakkında");
        }

        // Başlık
        TextView titleTV = findViewById(R.id.about_title);
        titleTV.setText("CubeWorld");
        titleTV.setTextSize(32);
        titleTV.setTextColor(Color.parseColor("#FF6B35"));

        // Yapımcı
        TextView developerTV = findViewById(R.id.about_developer);
        developerTV.setText("Yapımcı: Zodiac Games Studio\n© 2026 Tüm Hakları Saklıdır");
        developerTV.setTextColor(Color.parseColor("#004E89"));

        // Sürüm
        TextView versionTV = findViewById(R.id.about_version);
        versionTV.setText("Sürüm: 1.0.0");

        // Açıklama
        TextView descriptionTV = findViewById(R.id.about_description);
        descriptionTV.setText("CubeWorld, Minecraft Bedrock oyun mekaniklerine dayanan, açık kaynak tabanlı " +
                "bir sandbox oyunudur. Zodiac Games tarafından özel olarak geliştirilmiştir.\n\n" +
                "Sınırsız yaratıcılık dünyasında blok inşa et, keşfet ve oyna!");

        // Özellikler
        TextView featuresTV = findViewById(R.id.about_features);
        StringBuilder features = new StringBuilder();
        features.append("✓ Sınırsız Blok Dünyası\n");
        features.append("✓ Minecraft Bedrock Kontrolleri\n");
        features.append("✓ Çok Oyunculu Desteği (Multiplayer)\n");
        features.append("✓ Arkadaş Sistemi\n");
        features.append("✓ Survival & Creative Modları\n");
        features.append("✓ Mobil Optimizasyon\n");
        features.append("✓ Türkçe Dil Desteği\n");
        features.append("✓ Açık Kaynak Proje");
        
        featuresTV.setText(features.toString());
        featuresTV.setTextColor(Color.parseColor("#1A1A1A"));

        // İletişim
        TextView contactTV = findViewById(R.id.about_contact);
        contactTV.setText("📧 GitHub: github.com/ahmedemintokgoz2510-ctrl/CubeWorldd\n" +
                "🌐 Web: zodiacgames.studio\n" +
                "📱 Mobil: Android 5.0+");

        // Lisans
        TextView licenseTV = findViewById(R.id.about_license);
        licenseTV.setText("Lisans: GNU LGPL 2.1\n" +
                "Motor: Luanti (Minetest)\n" +
                "Platform: Android");
        licenseTV.setTextColor(Color.parseColor("#555555"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
