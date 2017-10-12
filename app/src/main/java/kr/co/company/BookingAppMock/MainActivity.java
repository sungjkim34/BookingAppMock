package kr.co.company.BookingAppMock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormatSymbols;

public class MainActivity extends Activity {

	private LinearLayout checkinButton;
	private LinearLayout checkoutButton;
	private LinearLayout submitButton;
	private TextView ciDayText;
	private TextView ciMonthText;
	private TextView ciDayOfWeekText;
	private TextView coDayText;
	private TextView coMonthText;
	private TextView coDayOfWeekText;
	private String ciDay;
	private String ciMonth;
	private String ciDayOfWeek;
	private String coDay;
	private String coMonth;
	private String coDayOfWeek;


	public String getMonth(int month) {
		return new DateFormatSymbols().getMonths()[month];
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		checkinButton = (LinearLayout) findViewById(R.id.checkinButton);
		checkoutButton = (LinearLayout) findViewById(R.id.checkoutButton);
		submitButton = (LinearLayout) findViewById(R.id.submitButton);
		ciDayText = (TextView) findViewById(R.id.ciDay);
		ciMonthText = (TextView) findViewById(R.id.ciMonth);
		ciDayOfWeekText = (TextView) findViewById(R.id.ciDOW);
		coDayText = (TextView) findViewById(R.id.coDay);
		coMonthText = (TextView) findViewById(R.id.coMonth);
		coDayOfWeekText = (TextView) findViewById(R.id.coDOW);

		Intent incoming = getIntent();

		ciMonth = incoming.getStringExtra("inMonth");
		ciDay = incoming.getStringExtra("inDay");
		ciDayOfWeek = incoming.getStringExtra("inDayOfWeek");

		coMonth = incoming.getStringExtra("outMonth");
		coDay = incoming.getStringExtra("outDay");
		coDayOfWeek = incoming.getStringExtra("outDayOfWeek");

		ciDayText.setText(ciDay == null ? "29" : ciDay);
		ciMonthText.setText(ciMonth == null ? "June" : getMonth(Integer.parseInt(ciMonth)));
		ciDayOfWeekText.setText(ciDayOfWeek == null ? "MONDAY" : ciDayOfWeek.toUpperCase());

		coDayText.setText(coDay == null ? "4" : coDay);
		coMonthText.setText(coMonth == null ? "July" : getMonth(Integer.parseInt(coMonth)));
		coDayOfWeekText.setText(coDayOfWeek == null ? "SATURDAY" : coDayOfWeek.toUpperCase());

		checkinButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent checkInIntent = new Intent(MainActivity.this,CalendarActivity.class);
				checkInIntent.putExtra("check", "in");
				startActivity(checkInIntent);
				finish();
			}
		});

		checkoutButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent checkOutIntent = new Intent(MainActivity.this,CalendarActivity.class);
				checkOutIntent.putExtra("check", "out");
				startActivity(checkOutIntent);
				finish();
			}
		});

		submitButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.d("DEBUG", "Submit button clicked.");
			}
		});
	}
}
