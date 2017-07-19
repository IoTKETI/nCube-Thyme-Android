/*
 * ------------------------------------------------------------------------
 * Copyright 2014 Korea Electronics Technology Institute
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ------------------------------------------------------------------------
 */

package kr.re.keti.nCubeThyme.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kr.re.keti.nCubeThyme.MainActivity;
import kr.re.keti.nCubeThyme.R;


public class NCubeSetting extends Activity {

    private String setDefault() {
        String defaultXML =
                "{\n" +
                        "\"useprotocol\": \"http\",\n" +
                        "\"cse\": {\n" +
                                "\"cbhost\": \"203.253.128.161\",\n" +
                                "\"cbport\": \"7579\",\n" +
                                "\"cbname\": \"Mobius\",\n" +
                                "\"cbcseid\": \"/Mobius\",\n" +
                                "\"mqttport\": \"1883\"\n" +
                        "},\n" +
                        "\"ae\": {\n" +
                                "\"aeid\": \"S\",\n" +
                                "\"appid\": \"0.2.481.1.1\",\n" +
                                "\"appname\": \"anCubeTest\",\n" +
                                "\"appport\": \"9727\",\n" +
                                "\"bodytype\": \"xml\",\n" +
                                "\"tasport\": \"7622\"\n" +
                        "},\n" +
                        "\"cnt\": [\n" +
                                "{\n" +
                                "\"parentpath\": \"/anCubeTest\",\n" +
                                "\"ctname\": \"sensorTest\"\n" +
                                "},\n" +
                                "{\n" +
                                "\"parentpath\": \"/anCubeTest\",\n" +
                                "\"ctname\": \"actuatorTest\"\n" +
                                "}\n" +
                        "],\n" +
                        "\"sub\": [\n" +
                                 "{\n" +
                                "\"parentpath\": \"/anCubeTest/actuatorTest\",\n" +
                                "\"subname\": \"sub-ctrl\",\n" +
                                "\"nu\": \"mqtt://AUTOSET\"\n" +
                                "}\n" +
                        "]\n" +
                "}\n";

        return defaultXML;
    }

    private String getEditTexts() {
        String getData = "";

        EditText configXMLEditText = (EditText) findViewById(R.id.configXMLEditText);
        getData = configXMLEditText.getText().toString();

        return getData;
    }

    private boolean checkSettingData(String inputData) {
        boolean check = false;

        if (!inputData.isEmpty() && inputData != null) {
            check = true;
        }

        return check;
    }

    private void setEditTexts(String inputData) {
        EditText configXMLEditText = (EditText) findViewById(R.id.configXMLEditText);
        configXMLEditText.setText(inputData);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ncube_setting);

        findViewById(R.id.submitSetting).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Submit
                        NCubeSettingDataShare submitData = new NCubeSettingDataShare(getEditTexts());

                        if (checkSettingData(getEditTexts())) {
                            Intent intent = new Intent(NCubeSetting.this, MainActivity.class);
                            intent.putExtra("setting", submitData);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Must fill all taps", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        findViewById(R.id.defaultSubmitSetting).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Default set editText
                        String defaultData = setDefault();
                        setEditTexts(defaultData);
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ncube_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
