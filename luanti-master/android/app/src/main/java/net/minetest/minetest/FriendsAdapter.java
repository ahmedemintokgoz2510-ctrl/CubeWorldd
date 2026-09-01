package net.minetest.minetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private Context context;
    private List<Friend> friends;

    public FriendsAdapter(Context context, List<Friend> friends) {
        super(context, 0, friends);
        this.context = context;
        this.friends = friends;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.friend_list_item, parent, false);
        }

        Friend friend = friends.get(position);

        // Kullanıcı adı
        TextView usernameTV = convertView.findViewById(R.id.friend_username);
        usernameTV.setText(friend.username);

        // Durum göstergesi
        ImageView statusIndicator = convertView.findViewById(R.id.friend_status);
        if (friend.isOnline) {
            statusIndicator.setBackgroundColor(android.graphics.Color.GREEN);
            TextView statusTV = convertView.findViewById(R.id.friend_status_text);
            statusTV.setText("Çevrimiçi");
        } else {
            statusIndicator.setBackgroundColor(android.graphics.Color.GRAY);
            TextView statusTV = convertView.findViewById(R.id.friend_status_text);
            statusTV.setText("Çevrimdışı");
        }

        // Butonlar
        Button inviteButton = convertView.findViewById(R.id.invite_button);
        inviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Davet gönder
            }
        });

        Button removeButton = convertView.findViewById(R.id.remove_button);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arkadaş sil
                friends.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
