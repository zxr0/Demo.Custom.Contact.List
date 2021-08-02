package sg.edu.rp.c346.id20000892.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter  extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;

    public CustomAdapter (@NonNull Context context, int resource, @NonNull ArrayList<Contact> objects){
        super (context, resource, objects);
        parent_context = context;
        layout_id = resource;
        contactList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvName  = rowView.findViewById(R.id.Name);
        TextView tvCode  = rowView.findViewById(R.id.CountryCode);
        TextView tvNum  = rowView.findViewById(R.id.Number);
        ImageView ivGender = rowView.findViewById(R.id.imageView);

        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode() );
        tvNum.setText(currentItem.getPhoneNum() + " ");

        char gender = currentItem.getGender();

        if (gender == 'F' || gender == 'f'){
            ivGender.setImageResource(R.drawable.female);
        }
        else{
            ivGender.setImageResource(R.drawable.male);
        }

        return rowView;
    }
}