package sg.edu.rp.c346.p11_mydatabook;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    Button btn;
    TextView tv;
    EditText etEdit;



    public BioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bio, container, false);

        tv = view.findViewById(R.id.tv);

        SharedPreferences pref = getContext().getSharedPreferences("pref", MODE_PRIVATE);
        String input = pref.getString("bio", "");



        if (input.equalsIgnoreCase("")){

        }else{
            tv.setText(input);
        }

        btn = view.findViewById(R.id.btnEdit);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view1 = inflater.inflate(R.layout.activity_dialog, null);
                etEdit = view1.findViewById(R.id.etEdit);
                etEdit.setText(tv.getText().toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Edit Bio").setView(view1).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv.setText(etEdit.getText().toString());
                        SharedPreferences pref = getContext().getSharedPreferences("pref", MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("bio", etEdit.getText().toString());
                        editor.commit();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });



        return view;
    }



}