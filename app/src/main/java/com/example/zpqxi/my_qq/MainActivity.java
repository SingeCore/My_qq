package com.example.zpqxi.my_qq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> mMsglist = new ArrayList<>();
    private EditText InputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdpater adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        InputText = findViewById(R.id.input_text);
        send = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.recyclerv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(linearLayoutManager);
        adpater = new MsgAdpater(mMsglist);
        msgRecyclerView.setAdapter(adpater);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = InputText.getText().toString();
                if (!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    mMsglist.add(msg);
                    adpater.notifyItemInserted(mMsglist.size()-1);
//                    adpater.notifyDataSetChanged();
                    msgRecyclerView.scrollToPosition(mMsglist.size()-1);
                    InputText.setText("");
                }
            }
        });
    }
    public void initMsg(){
      Msg msg1 = new Msg("Hello guy",Msg.TYPE_RECEIVED);
      mMsglist.add(msg1);
      Msg msg2 = new Msg("hello,who is that",Msg.TYPE_SENT);
      mMsglist.add(msg2);
      Msg msg3 = new Msg("this is tom,nice talking to you",Msg.TYPE_RECEIVED);
      mMsglist.add(msg3);
    }
}
