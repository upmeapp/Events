package assaf.zfani.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        View root = findViewById(R.id.rootView);
        ViewTreeObserver viewTreeObserver=root.getViewTreeObserver();
        viewTreeObserver.addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) { //the old focus and the new focus
                if(oldFocus instanceof EditText && newFocus instanceof EditText)
                {
                EditText oldF = (EditText)oldFocus;
                EditText newF=(EditText)newFocus;
                textView.setText("focus moved from: "+oldF.getText().toString()+" to: "+newF.getText().toString());
                }
            }
        });

    }
}
