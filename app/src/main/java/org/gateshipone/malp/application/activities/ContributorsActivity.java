/*
 *  Copyright (C) 2017 Team Gateship-One
 *  (Hendrik Borghorst & Frederik Luetkes)
 *
 *  The AUTHORS.md file contains a detailed contributors list:
 *  <https://github.com/gateship-one/malp/blob/master/AUTHORS.md>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.gateshipone.malp.application.activities;


import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.gateshipone.malp.R;
import org.gateshipone.malp.application.utils.ThemeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContributorsActivity extends GenericActivity {

    private static final String CONTRIBUTOR_NAME_KEY = "name";

    private static final String CONTRIBUTOR_TYPE_KEY = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributors);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ThemeUtils.getThemeColor(this, R.attr.malp_color_primary_dark));
        }

        ListView contributors = (ListView) findViewById(R.id.contributors_listview);

        String[] contributors_names = getResources().getStringArray(R.array.contributors);
        String[] contributors_types = getResources().getStringArray(R.array.contributors_type);

        List<Map<String, String>> contributors_list = new ArrayList<>();
        Map<String, String> map;

        for (int i = 0; i < contributors_names.length; i++) {
            map = new HashMap<>();
            map.put(CONTRIBUTOR_NAME_KEY, contributors_names[i]);
            map.put(CONTRIBUTOR_TYPE_KEY, contributors_types[i]);
            contributors_list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, contributors_list, R.layout.listview_item,
                new String[] {CONTRIBUTOR_NAME_KEY, CONTRIBUTOR_TYPE_KEY}, new int[] { R.id.item_title, R.id.item_subtitle });

        contributors.setAdapter(adapter);
    }
    @Override
    protected void onConnected() {

    }

    @Override
    protected void onDisconnected() {

    }
}
