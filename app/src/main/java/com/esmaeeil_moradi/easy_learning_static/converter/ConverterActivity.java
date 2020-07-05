package com.esmaeeil_moradi.easy_learning_static.converter;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.esmaeeil_moradi.easy_learning_static.R;
import com.jaredrummler.materialspinner.MaterialSpinner;


public class ConverterActivity extends AppCompatActivity {
    static final double RESULT = 0;
    public EditText edtInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        final TextView txtSI = findViewById(R.id.txtSI);
        final TextView txtResult = findViewById(R.id.txtResult);
        final Button btnConvert = findViewById(R.id.btnConvert);
        // final double INPUT = Double.parseDouble(edtInput.getText().toString());
        edtInput = findViewById(R.id.txtInput);

        //Set the toolbar as the activity's app bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //Enable the Up button.
        actionBar.setDisplayHomeAsUpEnabled(true);


        final MaterialSpinner spinner1 = findViewById(R.id.spinner1);
        final MaterialSpinner spinner2 = findViewById(R.id.spinner2);

        edtInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtInput.getText().clear(); //or you can use editText.setText("");

            }
        });


        spinner1.setItems("Acceleration", "Area", "Energy", "Force",
                "Impulse", "Length", "Mass", "Moment of a force",
                "Moment of inertia", "Momentum", "Power", "Pressure or stress",
                "Velocity", "Volume", "Work");
        spinner1.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
//                Log.e("Essi", "view:" + String.valueOf(view));
//                Log.e("Essi", "position:" + String.valueOf(position));
//                Log.e("Essi", "id:" + String.valueOf(id));
//                Log.e("Essi", "item:" + String.valueOf(item));


                switch (item) {
                    case "Acceleration":
                        spinner2.setItems("ft/s 2", "in./s2");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                txtSI.setText("m/s2");
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "ft/s 2") {
                                            //Log.e("Essi","0000000000000000000000000000000000000000" );
                                            //Log.e("Essi",edtInput.getText().toString() );
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.3048);
                                            //Log.e("Essi", Double.toString(a));

                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                            //Log.e("Essi", edtInput.getText().toString());

                                        } else if (itemSp2 == "in./s2") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.0254);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);

                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });

                            }
                        });
                        break;

                    case "Area":
                        spinner2.setItems("ft2", "in 2");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if (itemSp2 == "ft2") {
                                    txtSI.setText("m2");
                                } else if (itemSp2 == "in 2") {
                                    txtSI.setText("mm2");
                                } else {
                                    Log.e("Essi", txtSI.getText().toString() + "Error");
                                }
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "ft2") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.0929);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "in 2") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (645.2);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });


                        break;
                    case "Energy":
                        spinner2.setItems("ft . lb");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                txtSI.setText("J");

                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "ft . lb") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (1.356);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });


                        break;
                    case "Force":
                        spinner2.setItems("kip", "lb", "oz");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if (itemSp2 == "kip") {
                                    txtSI.setText("kN");
                                } else if ((itemSp2 == "in 2") || (itemSp2 == "oz")) {
                                    txtSI.setText("N");
                                } else {
                                    Log.e("Essi", txtSI.getText().toString() + "Error");
                                }
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "kip") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (4.448);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "lb") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (4.448);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "oz") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.2780);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });

                        break;
                    case "Impulse":
                        spinner2.setItems("lb . S");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                txtSI.setText("N . s");

                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "lb . S") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (4.448);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });


                        break;
                    case "Length":
                        spinner2.setItems("ft", "in.", "mi");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if (itemSp2 == "ft") {
                                    txtSI.setText("m");
                                } else if ((itemSp2 == "in.")) {
                                    txtSI.setText("mm");
                                } else if ((itemSp2 == "mi")) {
                                    txtSI.setText("km");
                                } else {
                                    Log.e("Essi", txtSI.getText().toString() + "Error");
                                }
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "ft") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.3048);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "in.") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (25.40);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "mi") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (1.609);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });


                        break;
                    case "Mass":
                        spinner2.setItems("oz mass", "lb mass", "slug", "ton");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if (itemSp2 == "oz mass") {
                                    txtSI.setText("g");
                                } else if ((itemSp2 == "lb mass") ||
                                        (itemSp2 == "slug") ||
                                        (itemSp2 == "ton")) {
                                    txtSI.setText("kg");
                                } else {
                                    Log.e("Essi", txtSI.getText().toString() + "Error");
                                }
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "oz mass") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (28.35);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "lb mass") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.4536);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "slug") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (14.59);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "ton") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (907.2);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });


                        break;
                    case "Moment of a force":
                        spinner2.setItems("lb . ft", "lb . in.");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if ((itemSp2 == "lb . ft") || (itemSp2 == "lb . in.")) {
                                    txtSI.setText("N . m");
                                } else {
                                    Log.e("Essi", txtSI.getText().toString() + "Error");
                                }
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "lb . ft") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (1.356);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "lb . in.") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.1130);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });


                        break;
                    case "Moment of inertia":
                        spinner2.setItems("Of an area --> in 4", "Of a mass --> lb . ft . s 2");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if ((itemSp2 == "Of an area --> in 4")) {
                                    txtSI.setText("mm 4");
                                } else if ((itemSp2 == "Of a mass --> lb . ft . s 2")) {
                                    txtSI.setText("kg . m2");


                                } else {
                                    Log.e("Essi", txtSI.getText().toString() + "Error");
                                }
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "Of an area --> in 4") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.4162 * 1000000);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "Of a mass --> lb . ft . s 2") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (1.356);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });


                        break;
                    case "Momentum":
                        spinner2.setItems("lb . s");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if (itemSp2 == "lb . s") txtSI.setText("kg . m/s");

                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "lb . s") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (4.448);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                            //Log.e("Essi", edtInput.getText().toString());

                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });

                            }
                        });

                        break;
                    case "Power":
                        spinner2.setItems("ft . lb/s", "hp");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if ((itemSp2 == "ft . lb/s") || (itemSp2 == "hp")) {
                                    txtSI.setText("W");
                                } else {
                                    Log.e("Essi", txtSI.getText().toString() + "Error");
                                }
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "ft . lb/s") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (1.356);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "hp") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (745.7);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });


                        break;
                    case "Pressure or stress":
                        spinner2.setItems("lb/ft 2", "lb/in 2 (psi)");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if ((itemSp2 == "ft . lb/s")) {
                                    txtSI.setText("Pa");
                                } else if ((itemSp2 == "lb/in 2 (psi)")) {
                                    txtSI.setText("KPa");
                                } else
                                    Log.e("Essi", txtSI.getText().toString() + "Error");
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "lb/ft 2") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (47.88);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "lb/in 2 (psi)") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (6.895);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });


                        break;
                    case "Velocity":
                        spinner2.setItems("ft/s", "in./s", "mi/h (mph)", "mi/h (mph) to km/h");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if ((itemSp2 == "ft/s") ||
                                        (itemSp2 == "in./s") ||
                                        (itemSp2 == "mi/h (mph)")) {
                                    txtSI.setText("m/s");
                                } else if (itemSp2 == "mi/h (mph)") {
                                    txtSI.setText("km/h");
                                } else {
                                    Log.e("Essi", txtSI.getText().toString() + "Error");
                                }
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "ft/s") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.3048);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "in./s") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.0254);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "mi/h (mph)") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.4470);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "mi/h (mph) to km/h") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (1.609);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });

                        break;
                    case "Volume":
                        spinner2.setItems("ft 3", "in 3", "gal", "qt");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                if ((itemSp2 == "gal") ||
                                        (itemSp2 == "qt")) {
                                    txtSI.setText("L");
                                } else if (itemSp2 == "ft 3") {
                                    txtSI.setText("m 3");
                                } else if (itemSp2 == "in 3") {
                                    txtSI.setText("cm3");
                                } else {
                                    Log.e("Essi", txtSI.getText().toString() + "Error");
                                }
                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "ft 3") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.02832);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "in 3") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (16.39);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "gal") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (3.785);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else if (itemSp2 == "qt") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (0.9464);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });
                        break;
                    case "Work":
                        spinner2.setItems("ft . lb");
                        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, final Object itemSp2) {
                                txtSI.setText("J");

                                btnConvert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (itemSp2 == "ft . lb") {
                                            double a = (Double.parseDouble(String.valueOf(edtInput.getText()))) * (1.356);
                                            String finalResult = Double.toString(a);
                                            txtResult.setText(finalResult);
                                        } else {
                                            Log.e("Essi", edtInput.getText().toString() + "Error");
                                        }
                                    }
                                });
                            }
                        });
                        break;


                }


            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

