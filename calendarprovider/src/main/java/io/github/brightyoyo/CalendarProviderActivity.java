package io.github.brightyoyo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Calendar;


public class CalendarProviderActivity extends AppCompatActivity {

    // Projection array.Creating indices for this array instead of doing
    // dynamic lookups improves performance.
    public static final String[] CALENDAR_PROJECTION = new String[]{
            Calendars._ID,                          // 0
            Calendars.ACCOUNT_NAME,                 // 1
            Calendars.CALENDAR_DISPLAY_NAME,        // 2
            Calendars.OWNER_ACCOUNT                 // 3
    };

    public static final String[] EVENT_PROJECTION = new String[]{
            Events._ID,
            Events.ORGANIZER,
            Events.TITLE,
            Events.EVENT_LOCATION,
            Events.DESCRIPTION,
            Events.DTSTART,
            Events.DTEND,
            Events.EVENT_TIMEZONE,
            Events.EVENT_END_TIMEZONE,
            Events.DURATION,
            Events.ALL_DAY,
            Events.RRULE,
            Events.RDATE,
            Events.AVAILABILITY,
            Events.GUESTS_CAN_MODIFY,
            Events.GUESTS_CAN_INVITE_OTHERS,
            Events.GUESTS_CAN_SEE_GUESTS,
    };

    // The indices for the projection array above.
    private static final int PROJECTION_ID_INDEX = 0;
    private static final int PROJECTION_ACCOUNT_NAME_INDEX = 1;
    private static final int PROJECTION_DISPLAY_NAME_INDEX = 2;
    private static final int PROJECTION_OWNER_ACCOUNT_INDEX = 3;
    private static final String TAG = "CalendarProvider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void queryCalendar(View view) {
        // Run query
        Cursor cur;
        ContentResolver cr = getContentResolver();
        Uri uri = Calendars.CONTENT_URI;
        String selection = "(" + Calendars.CALENDAR_DISPLAY_NAME + "=?)";
        String[] selectionArgs = new String[]{
                "droideep@163.com"
        };
        cur = cr.query(uri, CALENDAR_PROJECTION, selection, selectionArgs, null);

        // Use the cursor to step through the returned records
        while (cur.moveToNext()) {
            long calID;
            String displayName;
            String accountName;
            String ownerName;

            // Get the field values
            calID = cur.getLong(PROJECTION_ID_INDEX);
            displayName = cur.getString(PROJECTION_DISPLAY_NAME_INDEX);
            accountName = cur.getString(PROJECTION_ACCOUNT_NAME_INDEX);
            ownerName = cur.getString(PROJECTION_OWNER_ACCOUNT_INDEX);
            Log.d(TAG, String.format("calId:%s,displayName:%s,accountName:%s,ownerName:%s",
                    calID, displayName, accountName, ownerName));


            // Do something with the values...
            // ...
        }
    }

    public void queryEvent(View v) {
        Cursor cur;
        ContentResolver cr = getContentResolver();
        Uri uri = Events.CONTENT_URI;
        String selection = "(" + Events.DTSTART + ">?)";
        long startMillis;
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2015, 6, 14); // 年月日
        startMillis = beginTime.getTimeInMillis();
        String[] selectionArgs = new String[]{
                Long.toString(startMillis)
        };
        cur = cr.query(uri, EVENT_PROJECTION, selection, selectionArgs, null);
        while (cur.moveToNext()) {
            StringBuffer sb = new StringBuffer("");
            int size = EVENT_PROJECTION.length;
            for (int i = 0; i < size; i++) {
                sb.append(EVENT_PROJECTION[i] + ":");
                sb.append(cur.getString(i) + ",");
            }
            Log.d(TAG, sb.toString());
        }
    }

}
