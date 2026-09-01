package net.minetest.minetest;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends AppCompatActivity {

    private ListView friendsListView;
    private EditText friendUsernameEditText;
    private Button addFriendButton;
    private List<Friend> friendsList;
    private FriendsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Arkadaşlar");
        }

        // UI Bileşenleri
        friendsListView = findViewById(R.id.friends_list);
        friendUsernameEditText = findViewById(R.id.friend_username_input);
        addFriendButton = findViewById(R.id.add_friend_button);

        // Arkadaş Listesini Başlat
        friendsList = new ArrayList<>();
        loadFriends();

        // Adapter Ayarla
        adapter = new FriendsAdapter(this, friendsList);
        friendsListView.setAdapter(adapter);

        // Arkadaş Ekle Butonu
        addFriendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFriend();
            }
        });
    }

    private void addFriend() {
        String username = friendUsernameEditText.getText().toString().trim();
        
        if (username.isEmpty()) {
            Toast.makeText(this, "Kullanıcı adı girin", Toast.LENGTH_SHORT).show();
            return;
        }

        // Veritabanına ekle
        Friend friend = new Friend(username, true);
        friendsList.add(friend);
        adapter.notifyDataSetChanged();
        
        friendUsernameEditText.setText("");
        Toast.makeText(this, username + " arkadaş olarak eklendi", Toast.LENGTH_SHORT).show();
    }

    private void loadFriends() {
        // Veritabanından arkadaşları yükle
        // Örnek veri
        friendsList.add(new Friend("Player1", true));
        friendsList.add(new Friend("Player2", false));
        friendsList.add(new Friend("Player3", true));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

// Friend Model
class Friend {
    public String username;
    public boolean isOnline;

    public Friend(String username, boolean isOnline) {
        this.username = username;
        this.isOnline = isOnline;
    }
}
