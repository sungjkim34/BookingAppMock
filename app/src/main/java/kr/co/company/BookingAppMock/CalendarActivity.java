package kr.co.company.BookingAppMock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.CalendarView;

import java.util.Date;

public class CalendarActivity extends Activity  {
    private CalendarView mCalendarView;
    private long initialDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        initialDate = mCalendarView.getDate();

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                if (CalendarView.getDate() == initialDate) {
                    return;
                }
                Date d = new Date(year - 1900, month, dayOfMonth);
                String dayOfWeek = DateFormat.format("EEEE", d).toString();
                Intent intent = new Intent(CalendarActivity.this,MainActivity.class);
                Intent incoming = getIntent();
                if(incoming.getStringExtra("check").equals("in")){
                    intent.putExtra("inMonth", Integer.toString(month));
                    intent.putExtra("inDay", Integer.toString(dayOfMonth));
                    intent.putExtra("inDayOfWeek", dayOfWeek);
                }
                else{
                    intent.putExtra("outMonth", Integer.toString(month));
                    intent.putExtra("outDay", Integer.toString(dayOfMonth));
                    intent.putExtra("outDayOfWeek", dayOfWeek);
                }
                startActivity(intent);
                finish();
            }
        });
    }
}
