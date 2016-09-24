package io.pello.android.layoutsamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MainActivity for layout samples
 */
public class MainActivity extends AppCompatActivity {

    private ListView layoutListView;
    private ArrayAdapter<String> layoutListAdapter;
    private String[] layoutItems = {
            "FrameLayoutActivity",
            "LinearLayoutHorizontalActivity",
            "LinearLayoutVerticalActivity",
            "GridLayoutActivity",
            "TableLayoutActivity",
            "RelativeLayoutActivity",
            "CombinationLayoutActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutListView = (ListView) findViewById(R.id.listView);
        loadList();
    }

    /**
     * Simple method to set up the list
     */
    private void loadList () {

        // Create a list based on String Array
        List<String> layoutList = new ArrayList<String>(Arrays.asList(layoutItems));

        // Create the Array Adapter
        layoutListAdapter =
                new ArrayAdapter<String>(
                        this, // The current context (this activity)
                        R.layout.list_item_layout, // The name of the layout ID.
                        R.id.list_item_layout_text, // The ID of the textview to populate.
                        layoutList);

        // Link the adapter with the view
        layoutListView.setAdapter(layoutListAdapter);

        // Add the handler for click event
        layoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = null;
                String layoutName = layoutListAdapter.getItem(position);

                Log.d("PELLODEBUG", "Selected name: " + layoutName);
                Toast.makeText(MainActivity.this, layoutName, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, LinearLayoutHorizontalActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, LinearLayoutVerticalActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, GridLayoutActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, TableLayoutActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this, CombinationLayoutActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }

        });
    }

}
