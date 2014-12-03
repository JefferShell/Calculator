package com.chanjet;

import com.chanjet.calculator.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	private Button btn_0;
	private Button btn_1;
	private Button btn_2;
	private Button btn_3;
	private Button btn_4;
	private Button btn_5;
	private Button btn_6;
	private Button btn_7;
	private Button btn_8;
	private Button btn_9;
	private Button btn_plus;
	private Button btn_clear;
	private Button btn_del;
	private Button btn_divide;
	private Button btn_multiply;
	private Button btn_minus;
	private Button btn_point;
	private Button btn_equal;
	private EditText input;
	private Boolean clean_flag = false;//清空标识

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initLayout();
		setButtonClick();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String con = input.getText().toString();
		switch (v.getId()) {
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
//		case R.id.btn_point:
			if(clean_flag==true){
				input.setText("");
			}
			input.setText(con + ((Button) v).getText());
			break;
		case R.id.btn_point:
			input.setText(clean_flag.toString());
			break;
		case R.id.btn_plus:
		case R.id.btn_minus:
		case R.id.btn_multiply:
		case R.id.btn_divide:
			if(clean_flag==true){
				input.setText("");
			}
			input.setText(con + " " + ((Button) v).getText() + "  ");
			break;
		case R.id.btn_clear:
			clean_flag = false;
			input.setText("");
			break;
		case R.id.btn_del:
			if(clean_flag == true){
				input.setText("");
			}
			else if (con != null || con.equals("")) {
				input.setText(con.substring(0, con.length() - 1));
			}
			break;
		case R.id.btn_equal:
			getResult();
			break;
		default:
			break;
		}
	}

	/*
	 * 运算结果
	 */
	private void getResult() {
		// TODO Auto-generated method stub
		String exp = input.getText().toString();
		if (exp == null || exp.equals("")) {
			return ;
		}
		if (!exp.contains(" ")) {
			return ;
		}
		if(clean_flag){
			clean_flag = false;
			return;
		}
		clean_flag = true;
		double result = 0;
		String s1 = exp.substring(0, exp.indexOf(" "));// 运算符前面的字符串
		String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);// 运算符
		String s2 = exp.substring(exp.indexOf(" ") + 3);
		if (!s1.equals("") && !s2.equals("")) {
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			switch (op) {
			case "+":
				result = d1 + d2;
				break;
			case "-":
				result = d1 - d2;
				break;
			case "*":
				result = d1 * d2;
				break;
			case "/":
				if (d2 == 0) {
					result = 0;
				} else {
					result = d1 / d2;
				}
				break;

			default:
				break;
			}
			if (!s1.contains(".") && !s2.contains(".")) {
				int m = (int) result;
				input.setText(m + "");
			} else {
				input.setText(result + "");
			}
		} else if (!s1.equals("") && s2.equals("")) {
			input.setText(exp);
		} else if (s1.equals("") && !s2.equals("")) {
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			switch (op) {
			case "+":
				result = 0 + d2;
				break;
			case "-":
				result = 0 - d2;
				break;
			case "*":
				result = 0;
				break;
			case "/":
				result = 0;
				break;
			default:
				break;
			}
			if (!s2.contains(".")) {
				int m = (int) result;
				input.setText(m + "");
			} else {
				input.setText(result + "");
			}
		}
		else{
			input.setText("");
		}
	}

	private void setButtonClick() {
		// TODO 设置按钮的点击事件
		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		btn_plus.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		btn_multiply.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_point.setOnClickListener(this);
		btn_equal.setOnClickListener(this);
	}

	private void initLayout() {
		// TODO 实例化按钮
		btn_0 = (Button) findViewById(R.id.btn_0);
		btn_1 = (Button) findViewById(R.id.btn_1);
		btn_2 = (Button) findViewById(R.id.btn_2);
		btn_3 = (Button) findViewById(R.id.btn_3);
		btn_4 = (Button) findViewById(R.id.btn_4);
		btn_5 = (Button) findViewById(R.id.btn_5);
		btn_6 = (Button) findViewById(R.id.btn_6);
		btn_7 = (Button) findViewById(R.id.btn_7);
		btn_8 = (Button) findViewById(R.id.btn_8);
		btn_9 = (Button) findViewById(R.id.btn_9);
		btn_plus = (Button) findViewById(R.id.btn_plus);
		btn_clear = (Button) findViewById(R.id.btn_clear);
		btn_del = (Button) findViewById(R.id.btn_del);
		btn_divide = (Button) findViewById(R.id.btn_divide);
		btn_multiply = (Button) findViewById(R.id.btn_multiply);
		btn_minus = (Button) findViewById(R.id.btn_minus);
		btn_point = (Button) findViewById(R.id.btn_point);
		btn_equal = (Button) findViewById(R.id.btn_equal);
		input = (EditText) findViewById(R.id.input);

	}
}
