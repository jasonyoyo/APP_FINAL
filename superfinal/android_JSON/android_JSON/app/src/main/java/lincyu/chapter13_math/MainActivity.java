package lincyu.chapter13_math;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {

    CheckBox cb_k,cb_ca,cb_ti,cb_cr,cb_mn,cb_fe,cb_ni,cb_cu,cb_zn,cb_as_,cb_sr,cb_pb,cb_mo_inc,cb_mo_coh;
    Spinner sp_k,sp_ca,sp_ti,sp_cr,sp_mn,sp_fe,sp_ni,sp_cu,sp_zn,sp_as_,sp_sr,sp_pb,sp_mo_inc,sp_mo_coh;
	EditText et_k,et_ca,et_ti,et_cr,et_mn,et_fe,et_ni,et_cu,et_zn,et_as_,et_sr,et_pb,et_mo_inc,et_mo_coh;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//對應到相對的圖示
        cb_k=(CheckBox)findViewById(R.id.checkBox_k);
        sp_k=(Spinner)findViewById(R.id.spinner_k);
		et_k=(EditText)findViewById(R.id.editText_k);
		cb_ca=(CheckBox)findViewById(R.id.checkBox_ca);
		sp_ca=(Spinner)findViewById(R.id.spinner_ca);
		et_ca=(EditText)findViewById(R.id.editText_ca);
		cb_ti=(CheckBox)findViewById(R.id.checkBox_ti);
		sp_ti=(Spinner)findViewById(R.id.spinner_ti);
		et_ti=(EditText)findViewById(R.id.editText_ti);
		cb_cr=(CheckBox)findViewById(R.id.checkBox_cr);
		sp_cr=(Spinner)findViewById(R.id.spinner_cr);
		et_cr=(EditText)findViewById(R.id.editText_cr);
		cb_mn=(CheckBox)findViewById(R.id.checkBox_mn);
		sp_mn=(Spinner)findViewById(R.id.spinner_mn);
		et_mn=(EditText)findViewById(R.id.editText_mn);
		cb_fe=(CheckBox)findViewById(R.id.checkBox_fe);
		sp_fe=(Spinner)findViewById(R.id.spinner_fe);
		et_fe=(EditText)findViewById(R.id.editText_fe);
		cb_ni=(CheckBox)findViewById(R.id.checkBox_ni);
		sp_ni=(Spinner)findViewById(R.id.spinner_ni);
		et_ni=(EditText)findViewById(R.id.editText_ni);
		cb_cu=(CheckBox)findViewById(R.id.checkBox_cu);
		sp_cu=(Spinner)findViewById(R.id.spinner_cu);
		et_cu=(EditText)findViewById(R.id.editText_cu);
		cb_zn=(CheckBox)findViewById(R.id.checkBox_zn);
		sp_zn=(Spinner)findViewById(R.id.spinner_zn);
		et_zn=(EditText)findViewById(R.id.editText_zn);
		cb_as_=(CheckBox)findViewById(R.id.checkBox_as_);
		sp_as_=(Spinner)findViewById(R.id.spinner_as_);
		et_as_=(EditText)findViewById(R.id.editText_as_);
		cb_sr=(CheckBox)findViewById(R.id.checkBox_sr);
		sp_sr=(Spinner)findViewById(R.id.spinner_sr);
		et_sr=(EditText)findViewById(R.id.editText_sr);
		cb_pb=(CheckBox)findViewById(R.id.checkBox_pb);
		sp_pb=(Spinner)findViewById(R.id.spinner_pb);
		et_pb=(EditText)findViewById(R.id.editText_pb);
		cb_mo_inc=(CheckBox)findViewById(R.id.checkBox_mo_inc);
		sp_mo_inc=(Spinner)findViewById(R.id.spinner_mo_inc);
		et_mo_inc=(EditText)findViewById(R.id.editText_mo_inc);
		cb_mo_coh=(CheckBox)findViewById(R.id.checkBox_mo_coh);
		sp_mo_coh=(Spinner)findViewById(R.id.spinner_mo_coh);
		et_mo_coh=(EditText)findViewById(R.id.editText_mo_coh);

		Button btnnew= (Button)findViewById(R.id.button2); //按鈕
		btnnew.setOnClickListener(send);
		//下拉選單
		Spinner spinner = (Spinner)findViewById(R.id.spinner_k);
		ArrayAdapter<CharSequence> judge = ArrayAdapter.createFromResource(this,
				R.array.items,
				android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(judge);
		Spinner spinner1 = (Spinner)findViewById(R.id.spinner_ca);
		spinner1.setAdapter(judge);
		Spinner spinner2 = (Spinner)findViewById(R.id.spinner_ti);
		spinner2.setAdapter(judge);
		Spinner spinner3 = (Spinner)findViewById(R.id.spinner_cr);
		spinner3.setAdapter(judge);
		Spinner spinner4 = (Spinner)findViewById(R.id.spinner_mn);
		spinner4.setAdapter(judge);
		Spinner spinner5 = (Spinner)findViewById(R.id.spinner_fe);
		spinner5.setAdapter(judge);
		Spinner spinner6 = (Spinner)findViewById(R.id.spinner_ni);
		spinner6.setAdapter(judge);
		Spinner spinner7 = (Spinner)findViewById(R.id.spinner_cu);
		spinner7.setAdapter(judge);
		Spinner spinner8 = (Spinner)findViewById(R.id.spinner_zn);
		spinner8.setAdapter(judge);
		Spinner spinner9 = (Spinner)findViewById(R.id.spinner_as_);
		spinner9.setAdapter(judge);
		Spinner spinner10 = (Spinner)findViewById(R.id.spinner_sr);
		spinner10.setAdapter(judge);
		Spinner spinner11 = (Spinner)findViewById(R.id.spinner_pb);
		spinner11.setAdapter(judge);
		Spinner spinner12 = (Spinner)findViewById(R.id.spinner_mo_inc);
		spinner12.setAdapter(judge);
		Spinner spinner13 = (Spinner)findViewById(R.id.spinner_mo_coh);
		spinner13.setAdapter(judge);

	}




	OnClickListener send = new OnClickListener() {
		@Override
		public void onClick(View v) {
			//建立切換頁面
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, MapsActivity.class);

            StringBuilder url = new StringBuilder("http://acolab.ie.nthu.edu.tw/wp-content/uploads/2017/Group2.php?k_=");
			//輸入值的判斷
            if(cb_k.isChecked()) {
				if (sp_k.getSelectedItemPosition() == 0)
					url.append("2&k=");
				else
					url.append("1&k=");
				url.append(et_k.getText().toString());
			}
			else
				url.append("1&k=-1");

			if(cb_ca.isChecked()) {
				url.append("&ca_=");
				if (sp_ca.getSelectedItemPosition() == 0)
					url.append("2&ca=");
				else
					url.append("1&ca=");
				url.append(et_ca.getText().toString());
			}
			if(cb_ti.isChecked()) {
				url.append("&ti_=");
				if (sp_ti.getSelectedItemPosition() == 0)
					url.append("2&ti=");
				else
					url.append("1&ti=");
				url.append(et_ti.getText().toString());
			}
			if(cb_cr.isChecked()) {
				url.append("&cr_=");
				if (sp_cr.getSelectedItemPosition() == 0)
					url.append("2&cr=");
				else
					url.append("1&cr=");
				url.append(et_cr.getText().toString());
			}
			if(cb_mn.isChecked()) {
				url.append("&mn_=");
				if (sp_mn.getSelectedItemPosition() == 0)
					url.append("2&mn=");
				else
					url.append("1&mn=");
				url.append(et_mn.getText().toString());
			}
			if(cb_fe.isChecked()) {
				url.append("&fe_=");
				if (sp_fe.getSelectedItemPosition() == 0)
					url.append("2&fe=");
				else
					url.append("1&fe=");
				url.append(et_fe.getText().toString());
			}
			if(cb_ni.isChecked()) {
				url.append("&ni_=");
				if (sp_ni.getSelectedItemPosition() == 0)
					url.append("2&ni=");
				else
					url.append("1&ni=");
				url.append(et_ni.getText().toString());
			}
			if(cb_cu.isChecked()) {
				url.append("&cu_=");
				if (sp_cu.getSelectedItemPosition() == 0)
					url.append("2&cu=");
				else
					url.append("1&cu=");
				url.append(et_cu.getText().toString());
			}
			if(cb_zn.isChecked()) {
				url.append("&zn_=");
				if (sp_zn.getSelectedItemPosition() == 0)
					url.append("2&zn=");
				else
					url.append("1&zn=");
				url.append(et_zn.getText().toString());
			}
			if(cb_as_.isChecked()) {
				url.append("&as__=");
				if (sp_as_.getSelectedItemPosition() == 0)
					url.append("2&as_=");
				else
					url.append("1&as_=");
				url.append(et_as_.getText().toString());
			}
			if(cb_sr.isChecked()) {
				url.append("&sr_=");
				if (sp_sr.getSelectedItemPosition() == 0)
					url.append("2&sr=");
				else
					url.append("1&sr=");
				url.append(et_sr.getText().toString());
			}
			if(cb_pb.isChecked()) {
				url.append("&pb_=");
				if (sp_pb.getSelectedItemPosition() == 0)
					url.append("2&pb=");
				else
					url.append("1&pb=");
				url.append(et_pb.getText().toString());
			}
			if(cb_mo_inc.isChecked()) {
				url.append("&mo_inc_=");
				if (sp_mo_inc.getSelectedItemPosition() == 0)
					url.append("2&mo_inc=");
				else
					url.append("1&mo_inc=");
				url.append(et_mo_inc.getText().toString());
			}
			if(cb_mo_coh.isChecked()) {
				url.append("&mo_coh_=");
				if (sp_mo_coh.getSelectedItemPosition() == 0)
					url.append("2&mo_coh=");
				else
					url.append("1&mo_coh=");
				url.append(et_mo_coh.getText().toString());
			}
			//
			Bundle bundle = new Bundle();
			bundle.putString("URL",url.toString());
			intent.putExtras(bundle);

			startActivity(intent);

		}
	};
}
