package com.epaylinks.myfirstframe.wedigitview;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.epaylinks.myfirstframe.R;
import com.epaylinks.myfirstframe.base.BaseActivity;

/**
 * Created by Administrator on 2016/12/15.
 */

public class Android23StudyActivity extends BaseActivity {

    private TextInputLayout til_container;
    private EditText edt_input_yout_email;
    private EditText edt_input_yout_email_nomal;
    private CoordinatorLayout cl_fab_container;
    private Snackbar snackbar;
    private FloatingActionButton fab_cop;

    @Override
    protected void setUpView() {
        til_container = (TextInputLayout) findViewById(R.id.til_container);
        edt_input_yout_email = (EditText) findViewById(R.id.edt_input_yout_email);
        edt_input_yout_email_nomal=(EditText) findViewById(R.id.edt_input_yout_email_nomal);
    }

    @Override
    protected void setUpData() {
        super.setUpData();
        til_container.setHintAnimationEnabled(true);
        til_container.setHint("请您的输入邮箱");
        edt_input_yout_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()>10){
                    til_container.setError("请输入的文字太长");
                    til_container.setErrorEnabled(true);
                }else {
                    til_container.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edt_input_yout_email_nomal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()>10){
                    edt_input_yout_email_nomal.setError("你输入的文字太长了");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //coordinatelayout
        cl_fab_container = (CoordinatorLayout) findViewById(R.id.cl_fab_container);
        snackbar = Snackbar.make(cl_fab_container,"哇塞，好棒，我这么的搞笑",Snackbar.LENGTH_LONG);
        snackbar.setAction("消失", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
                 Toast.makeText(Android23StudyActivity.this,"i will  go,did you missing me! ",Toast.LENGTH_LONG).show();
            }
        });
        snackbar.setCallback(new Snackbar.Callback(){

            @Override
            public void onShown(Snackbar sb) {
                super.onShown(sb);
                snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));
                Toast.makeText(Android23StudyActivity.this,"i onShown",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDismissed(Snackbar transientBottomBar, int event) {
                super.onDismissed(transientBottomBar, event);
                Toast.makeText(Android23StudyActivity.this,"ionDismissed! ",Toast.LENGTH_LONG).show();
            }
        });
        fab_cop = (FloatingActionButton) findViewById(R.id.fab_cop);
        //向右划出之后 点击无法再显示
        fab_cop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.show();
            }
        });
    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_android23);

    }
}
