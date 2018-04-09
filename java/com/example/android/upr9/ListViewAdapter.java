package com.example.android.upr9;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private String m_Text = "";
    private ArrayList<Course> list;
    private Context context;

    public ListViewAdapter(ArrayList<Course>list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item, viewGroup, false);
        }
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewScore = convertView.findViewById(R.id.textViewScore);
        View circleView = convertView.findViewById(R.id.circleView);
        CheckBox checkBox = convertView.findViewById(R.id.checkbox);

        Course course = list.get(position);
        GradientDrawable bgShape = (GradientDrawable) circleView.getBackground();
        bgShape.setColor(Color.parseColor(course.getColor()));
        textViewName.setText(course.getName());
        if(course.getScore() != -1) {
            textViewScore.setText(String.valueOf(course.getScore()));
        }
        checkBox.setChecked(course.isPassed());

        return convertView;
    }

    private void showMenu() {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Showalert(view);
            list.get(i).setScore(Float.parseFloat(m_Text));
            list.set(i, list.get(i));
    }

    public void Showalert(final View v ){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Enter Mark");
        builder.setMessage("Mark: ");
        final EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        AlertDialog.Builder builder1 = builder.setPositiveButton("Add Mark", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                m_Text = input.getText().toString();
            }
        });
        builder.setView(input);
        builder.show();
    }
}
