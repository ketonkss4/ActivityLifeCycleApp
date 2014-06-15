package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {



	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	private Integer mCreate = 0;
	private Integer mRestart = 0;
	private Integer mStart = 0;
	private Integer mResume = 0;
	
	static final String STATE_CREATE = "onCreateCounter";
	static final String STATE_RESTART = "onRestartCounter";
	static final String STATE_START = "onStartCounter";
	static final String STATE_RESUME = "onResumeCounter";
			
	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
	TextView mTvCreate;
	TextView mTvRestart;
	TextView mTvStart;
	TextView mTvResume;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// TODO: Assign the appropriate TextViews to the TextView variables 
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
		mCreate ++;
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvResume = (TextView) findViewById(R.id.resume);
		
		Log.i(TAG, "Entered the OnCreate Method");





		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method
				ActivityTwo.this.finish();


			
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = savedInstanceState.getInt(STATE_CREATE);
			mRestart = savedInstanceState.getInt(STATE_RESTART);
			mResume = savedInstanceState.getInt(STATE_RESUME);
			mStart = savedInstanceState.getInt(STATE_START);
			


		}

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered onCreate Method");
		



		// TODO:
		// Update the appropriate count variable
		mCreate++;
		// Update the user interface via the displayCounts() method
		displayCounts();




	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered onStart Method");
		


		// TODO:
		// Update the appropriate count variable
		mStart++;
		// Update the user interface
		displayCounts();



	}

	@Override
	public void onResume() {
		super.onResume();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered onResume Method");
		

		// TODO:
		// Update the appropriate count variable
		mResume++;
		// Update the user interface
		displayCounts();




	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered onPause method");



	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered onStop Method");
		


	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered onRestart Method");
		// TODO:
		// Update the appropriate count variable
		mRestart++;
		// Update the user interface
		displayCounts();



	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered onDestroy Method");
		

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// TODO:	
		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		savedInstanceState.putInt(STATE_CREATE, mCreate);
		savedInstanceState.putInt(STATE_RESTART, mRestart);
		savedInstanceState.putInt(STATE_START, mStart);
		savedInstanceState.putInt(STATE_RESUME, mResume);
		
		super.onSaveInstanceState(savedInstanceState);




	
	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
