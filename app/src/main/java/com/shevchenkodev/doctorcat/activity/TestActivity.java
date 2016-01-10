package com.shevchenkodev.doctorcat.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.shevchenkodev.doctorcat.R;


public class TestActivity extends AppCompatActivity {


    Integer numQuest = 1;
    Integer problems = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    public void clickNext(View view) {
        numQuest = 1;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test1)
                .setMessage(R.string.test1q)


                .setPositiveButton(R.string.yes, myClickListener)

                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                // положительная кнопка
                case Dialog.BUTTON_POSITIVE:
                    if (numQuest == 1) {
                        numQuest++;
                        problems++;
                        start2();
                        break;
                    } else if (numQuest == 2) {
                        numQuest++;
                        problems++;
                        start3();
                        break;
                    } else if (numQuest == 3) {
                        numQuest++;
                        problems++;
                        start4();
                        break;
                    } else if (numQuest == 4) {
                        numQuest++;
                        problems++;
                        start5();
                        break;
                    } else if (numQuest == 5) {
                        numQuest++;
                        problems++;
                        start6();
                        break;
                    } else if (numQuest == 6) {
                        numQuest++;
                        problems++;
                        start7();
                        break;
                    } else if (numQuest == 7) {
                        numQuest++;
                        problems++;
                        start8();
                        break;
                    } else if (numQuest == 8) {
                        numQuest++;
                        problems++;
                        start9();
                        break;
                    } else if (numQuest == 9) {
                        numQuest++;
                        problems++;
                        start10();
                        break;
                    } else if (numQuest == 10) {
                        numQuest++;
                        problems++;
                        start11();
                        break;
                    } else if (numQuest == 11) {
                        numQuest++;
                        problems++;
                        start12();
                        break;
                    } else if (numQuest == 12) {
                        numQuest++;
                        problems++;
                        start13();
                        break;
                    } else if (numQuest == 13) {
                        numQuest++;
                        problems++;
                        start14();
                        break;
                    } else if (numQuest == 14) {
                        numQuest++;
                        problems++;
                        start15();
                        break;
                    } else if (numQuest == 15) {
                        numQuest++;
                        problems++;
                        startfin();
                        break;
                    }

                    // негаитвная кнопка
                case Dialog.BUTTON_NEGATIVE:
                    if (numQuest == 1) {
                        numQuest++;

                        start2();
                        break;
                    } else if (numQuest == 2) {
                        numQuest++;
                        start3();
                        break;
                    } else if (numQuest == 3) {
                        numQuest++;
                        start4();
                        break;
                    } else if (numQuest == 4) {
                        numQuest++;
                        start5();
                        break;
                    } else if (numQuest == 5) {
                        numQuest++;
                        start6();
                        break;
                    } else if (numQuest == 6) {
                        numQuest++;
                        start7();
                        break;
                    } else if (numQuest == 7) {
                        numQuest++;
                        start8();
                        break;
                    } else if (numQuest == 8) {
                        numQuest++;
                        start9();
                        break;
                    } else if (numQuest == 9) {
                        numQuest++;
                        start10();
                        break;
                    } else if (numQuest == 10) {
                        numQuest++;
                        start11();
                        break;
                    } else if (numQuest == 11) {
                        numQuest++;
                        start12();
                        break;
                    } else if (numQuest == 12) {
                        numQuest++;
                        start13();
                        break;
                    } else if (numQuest == 13) {
                        numQuest++;
                        start14();
                        break;
                    } else if (numQuest == 14) {
                        numQuest++;
                        start15();
                        break;
                    } else if (numQuest == 15) {
                        numQuest++;
                        startfin();
                        break;
                    } else if (numQuest == 16) {
                        numQuest++;
                        starus();
                        break;
                    }
            }
        }
    };

    private void startfin() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.resulttest);
        if (problems < 1) {
            builder.setMessage(R.string.testok);
        } else {
            builder.setMessage(getString(R.string.bettest1) + problems + getString(R.string.bedtest2));
            ;
        }

        builder.setPositiveButton(R.string.returning, myClickListener);

        AlertDialog alert = builder.create();
        alert.show();
    }


    private void start2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test2)
                .setMessage(R.string.test2q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test3)
                .setMessage(R.string.test3q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test4)
                .setMessage(R.string.test4q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start5() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test5)
                .setMessage(R.string.test5q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start6() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test6)
                .setMessage(R.string.test6q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start7() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test7)
                .setMessage(R.string.test7q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start8() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test8)
                .setMessage(R.string.test8q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start9() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test9)
                .setMessage(R.string.yesy9q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start10() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test10)
                .setMessage(R.string.test10q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start11() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test11)
                .setMessage(R.string.tets11q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start12() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test12)
                .setMessage(R.string.test12q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start13() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test13)
                .setMessage(R.string.test13q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start14() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test14)
                .setMessage(R.string.test14q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void start15() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.test15)
                .setMessage(R.string.test15q)

                .setPositiveButton(R.string.yes, myClickListener)
                .setNegativeButton(R.string.no, myClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void starus() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.ratetit)
                .setMessage(R.string.ratequest)

                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("market://details?id=com.shevchenkodev.doctorcat"));

                        startActivity(i);
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        }
                );
        AlertDialog alert = builder.create();
        alert.show();


    }
}
