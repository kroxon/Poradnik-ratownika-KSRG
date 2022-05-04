package com.mynew.poradnikksrg.ui.adr;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mynew.poradnikksrg.R;

import java.util.ArrayList;
import java.util.List;

import com.mynew.poradnikksrg.AutoCompleteSubstanceAdapter;
import com.mynew.poradnikksrg.DataBaseHelper;
import com.mynew.poradnikksrg.DatabaseAccess;
import com.mynew.poradnikksrg.ProcedureClass;
import com.mynew.poradnikksrg.Substances;

public class AdrFragment extends Fragment {

    private AdrViewModel adrViewModel;

    List<String> namesSubs;

    ImageView foreView, effectsView, principlesView, clothingView, evacuationView, fireView, eorlView, firstAidView, loupeImage;

    LinearLayout foreLayout, effectsLayout, principleslayout, clothinglayout, evacuationlayout, fireLayout, eorlLayout, firstAidLayout, subsDescLayout, infoAppLayout;
    ConstraintLayout specSubsLayout;

    Button foreBtn, effectsBtn, principlesBtn, clothingBtn, evacuationBtn, fireBtn, eorlBtn, firstAidBtn;
    TextView nameText, onzText, procedureText, procDescription, foreText, effectText, principlesText, clothingText,
            evacuationText, fireText, eorlText, firstAidText, tLinkRatMed, tLinkRatChem, tLinkAnkieta;
    TextView exampleTv;
    EditText editText;

    AutoCompleteTextView autoCompleteTextView;
    DataBaseHelper myDb;
    List<Substances> subs;
    ArrayList<ProcedureClass> procedures;

    boolean flag = false;
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    boolean flag4 = false;
    boolean flag5 = false;
    boolean flag6 = false;
    boolean flag7 = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        adrViewModel =
                ViewModelProviders.of(this).get(AdrViewModel.class);
        View root = inflater.inflate(R.layout.fragment_adr, container, false);

        myDb = new DataBaseHelper(getActivity());

        foreView = root.findViewById(R.id.foreView);
        effectsView = root.findViewById(R.id.effectsView);
        principlesView = root.findViewById(R.id.principlesView);
        clothingView = root.findViewById(R.id.clothingView);
        evacuationView = root.findViewById(R.id.evacuationView);
        fireView = root.findViewById(R.id.fireView);
        eorlView = root.findViewById(R.id.eorlView);
        firstAidView = root.findViewById(R.id.firstAidView);

        foreLayout = root.findViewById(R.id.newLayoutForE);
        effectsLayout = root.findViewById(R.id.newLayoutEffects);
        principleslayout = root.findViewById(R.id.newLayoutPrinciples);
        clothinglayout = root.findViewById(R.id.newLayoutClothing);
        evacuationlayout = root.findViewById(R.id.newLayoutEvacuation);
        fireLayout = root.findViewById(R.id.newLayoutFire);
        eorlLayout = root.findViewById(R.id.newLayoutEorL);
        firstAidLayout = root.findViewById(R.id.newLayoutFirstAid);
        subsDescLayout = root.findViewById(R.id.subsDescLayout);
        infoAppLayout = root.findViewById(R.id.infoAppLayout);
        specSubsLayout = root.findViewById(R.id.substanseInformationLayout);


        foreBtn = root.findViewById(R.id.buttonForE);
        effectsBtn = root.findViewById(R.id.buttonEffects);

        nameText = root.findViewById(R.id.nameText);
        onzText = root.findViewById(R.id.onzNumberText);
        procDescription = root.findViewById(R.id.procDescription);

        loupeImage = root.findViewById(R.id.loupe);

        procedureText = root.findViewById(R.id.procNumText);
        foreText = root.findViewById(R.id.textViewForE);
        effectText = root.findViewById(R.id.textViewEffects);
        principlesText = root.findViewById(R.id.textViewPrinciples);
        clothingText = root.findViewById(R.id.textViewClothing);
        evacuationText = root.findViewById(R.id.textViewEvacuation);
        fireText = root.findViewById(R.id.textViewFire);
        eorlText = root.findViewById(R.id.textViewEorl);
        firstAidText = root.findViewById(R.id.textViewFirstAid);
        tLinkRatMed = root.findViewById(R.id.linkRatMed);
        tLinkRatChem = root.findViewById(R.id.linkRatChem);
        tLinkAnkieta = root.findViewById(R.id.linkAnkieta);

        exampleTv = root.findViewById(R.id.textViewExample);

        editText = root.findViewById(R.id.editText);

        autoCompleteTextView = root.findViewById(R.id.autoCompleteTextView);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());

        databaseAccess.open();
        subs = databaseAccess.getEverySubst();
        List<Substances> subs2 = new ArrayList<Substances>();
        databaseAccess.close();
        for (Substances s : subs) {
            if (s.getOnzNumber().equals("7777"))
                s.setOnzNumber("    ");
            if (isNameExists(s.getSubstName(), subs2))
                subs2.add(s);
        }
        subs = subs2;

        namesSubs = setList(subs);

        databaseAccess.open();
        procedures = (ArrayList<ProcedureClass>) databaseAccess.getEveryProc();
        databaseAccess.close();

        AutoCompleteSubstanceAdapter adapter = new AutoCompleteSubstanceAdapter(getContext(), subs);
        autoCompleteTextView.setAdapter(adapter);
        adrViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });



        // VieW Model

        if (adrViewModel.flagExpand == true) {

            // setting text views
            onzText.setText(adrViewModel.subsOnzNum);
            procedureText.setText(adrViewModel.subProcNum);
            nameText.setText(adrViewModel.subName);
            for (ProcedureClass p : procedures) {
                if (p.getpNumber() != null && p.getpNumber().contains(adrViewModel.subProcNum)) {
                    procDescription.setText(p.getpDescription());
                    foreText.setText(p.getpForE());
                    effectText.setText(p.getpEffect());
                    principlesText.setText(p.getpRelease());
                    clothingText.setText(p.getpClothing());
                    evacuationText.setText(p.getpEvacuation());
                    fireText.setText(p.getpFire());
                    eorlText.setText(p.getpEorL());
                    firstAidText.setText(p.getpFirstAid());

                    break;
                }
            }

            // expand layout
            infoAppLayout.setVisibility(View.GONE);
            specSubsLayout.setVisibility(View.VISIBLE);
            subsDescLayout.setVisibility(View.VISIBLE);


        }

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String onzNumb = "";
                String procNumb = "";
                int selectedPos = namesSubs.indexOf((autoCompleteTextView.getText()).toString());
                String selectedSubstance = namesSubs.get(selectedPos);

                // finding ONZ number and procedure number
                for (Substances s : subs) {
                    if (s.getSubstName() != null && (s.getSubstName().contains(selectedSubstance) || s.getOnzNumber().contains(selectedSubstance))) {
                        onzNumb = s.getOnzNumber();
                        if (onzNumb.equals("    "))
                            onzText.setText("brak nr ONZ");
                        else {
                            onzText.setText(onzNumb);
                            adrViewModel.subsOnzNum = onzNumb;
                        }
                        procNumb = s.getProcNum();
                        procedureText.setText("Nr procedury: " + procNumb);
                        adrViewModel.subProcNum = procNumb;
                        autoCompleteTextView.setText("  ");
                        nameText.setText(s.getSubstName());
                        adrViewModel.subName = s.getSubstName();

                        infoAppLayout.setVisibility(View.GONE);
                        specSubsLayout.setVisibility(View.VISIBLE);
                        expand(specSubsLayout);
                        subsDescLayout.setVisibility(View.VISIBLE);
                        expand(subsDescLayout);

                        // change viewModel flag
                        adrViewModel.flagExpand = true;

//                        Toast.makeText(getContext(), selectedSubstance, Toast.LENGTH_LONG).show();
                        break;
                    }
                }

                // setting other text views
                for (ProcedureClass p : procedures) {
                    if (p.getpNumber() != null && p.getpNumber().contains(procNumb)) {
                        procDescription.setText(p.getpDescription());
                        foreText.setText(p.getpForE());
                        effectText.setText(p.getpEffect());
                        principlesText.setText(p.getpRelease());
                        clothingText.setText(p.getpClothing());
                        evacuationText.setText(p.getpEvacuation());
                        fireText.setText(p.getpFire());
                        eorlText.setText(p.getpEorL());
                        firstAidText.setText(p.getpFirstAid());

                        break;
                    }
                }

                autoCompleteTextView.setHint(getResources().getString(R.string.myHint));
//                autoCompleteTextView.clearComposingText();


                //hiding keyboard

                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
                autoCompleteTextView.setText("");


//                autoCompleteTextView.dispatchDisplayHint(1);
            }
        });


        foreLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!flag) {


                    // collapse developed text views
                    if (flag1) {
                        effectsLayout.performClick();
                    }
                    if (flag2) {
                        principleslayout.performClick();
                    }
                    if (flag3) {
                        clothinglayout.performClick();
                    }
                    if (flag4) {
                        evacuationlayout.performClick();
                    }
                    if (flag5) {
                        fireLayout.performClick();
                    }
                    if (flag6) {
                        eorlLayout.performClick();
                    }
                    if (flag7) {
                        firstAidLayout.performClick();
                    }

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rotate_backward);
                            foreView.startAnimation(rotate);
                            flag = true;
                            expand(foreText);
                        }
                    }, 301);


                } else {
                    Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.rotate_forward);
                    foreView.startAnimation(rotate);
                    flag = false;
                    collapse(foreText);
                }

            }
        });

        effectsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!flag1) {


                    // collapse developed text views
                    if (flag) {
                        foreLayout.performClick();
                    }
                    if (flag2) {
                        principleslayout.performClick();
                    }
                    if (flag3) {
                        clothinglayout.performClick();
                    }
                    if (flag4) {
                        evacuationlayout.performClick();
                    }
                    if (flag5) {
                        fireLayout.performClick();
                    }
                    if (flag6) {
                        eorlLayout.performClick();
                    }
                    if (flag7) {
                        firstAidLayout.performClick();
                    }

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rotate_backward);
                            effectsView.startAnimation(rotate);
                            flag1 = true;
                            expand(effectText);
                        }
                    }, 301);

                } else {
                    Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.rotate_forward);
                    effectsView.startAnimation(rotate);
                    flag1 = false;
                    collapse(effectText);
                }

            }
        });

        principleslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!flag2) {

                    // collapse developed text views
                    if (flag) {
                        foreLayout.performClick();
                    }
                    if (flag1) {
                        effectsLayout.performClick();
                    }
                    if (flag3) {
                        clothinglayout.performClick();
                    }
                    if (flag4) {
                        evacuationlayout.performClick();
                    }
                    if (flag5) {
                        fireLayout.performClick();
                    }
                    if (flag6) {
                        eorlLayout.performClick();
                    }
                    if (flag7) {
                        firstAidLayout.performClick();
                    }

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rotate_backward);
                            principlesView.startAnimation(rotate);
                            flag2 = true;
                            expand(principlesText);
                        }
                    }, 301);

                } else {
                    Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.rotate_forward);
                    principlesView.startAnimation(rotate);
                    flag2 = false;
                    collapse(principlesText);
                }

            }
        });

        clothinglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag3) {


                    // collapse developed text views
                    if (flag) {
                        foreLayout.performClick();
                    }
                    if (flag1) {
                        effectsLayout.performClick();
                    }
                    if (flag2) {
                        principleslayout.performClick();
                    }
                    if (flag4) {
                        evacuationlayout.performClick();
                    }
                    if (flag5) {
                        fireLayout.performClick();
                    }
                    if (flag6) {
                        eorlLayout.performClick();
                    }
                    if (flag7) {
                        firstAidLayout.performClick();
                    }

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rotate_backward);
                            clothingView.startAnimation(rotate);
                            flag3 = true;
                            expand(clothingText);
                        }
                    }, 301);

                } else {
                    Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.rotate_forward);
                    clothingView.startAnimation(rotate);
                    flag3 = false;
                    collapse(clothingText);
                }
            }
        });

        evacuationlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag4) {


                    // collapse developed text views
                    if (flag) {
                        foreLayout.performClick();
                    }
                    if (flag1) {
                        effectsLayout.performClick();
                    }
                    if (flag2) {
                        principleslayout.performClick();
                    }
                    if (flag3) {
                        clothinglayout.performClick();
                    }
                    if (flag5) {
                        fireLayout.performClick();
                    }
                    if (flag6) {
                        eorlLayout.performClick();
                    }
                    if (flag7) {
                        firstAidLayout.performClick();
                    }

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rotate_backward);
                            evacuationView.startAnimation(rotate);
                            flag4 = true;
                            expand(evacuationText);
                        }
                    }, 301);

                } else {
                    Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.rotate_forward);
                    evacuationView.startAnimation(rotate);
                    flag4 = false;
                    collapse(evacuationText);
                }
            }
        });

        fireLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag5) {


                    // collapse developed text views
                    if (flag) {
                        foreLayout.performClick();
                    }
                    if (flag1) {
                        effectsLayout.performClick();
                    }
                    if (flag2) {
                        principleslayout.performClick();
                    }
                    if (flag3) {
                        clothinglayout.performClick();
                    }
                    if (flag4) {
                        evacuationlayout.performClick();
                    }
                    if (flag6) {
                        eorlLayout.performClick();
                    }
                    if (flag7) {
                        firstAidLayout.performClick();
                    }

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rotate_backward);
                            fireView.startAnimation(rotate);
                            flag5 = true;
                            expand(fireText);
                        }
                    }, 301);

                } else {
                    Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.rotate_forward);
                    fireView.startAnimation(rotate);
                    flag5 = false;
                    collapse(fireText);
                }
            }
        });

        eorlLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag6) {


                    // collapse developed text views
                    if (flag) {
                        foreLayout.performClick();
                    }
                    if (flag1) {
                        effectsLayout.performClick();
                    }
                    if (flag2) {
                        principleslayout.performClick();
                    }
                    if (flag3) {
                        clothinglayout.performClick();
                    }
                    if (flag4) {
                        evacuationlayout.performClick();
                    }
                    if (flag5) {
                        fireLayout.performClick();
                    }
                    if (flag7) {
                        firstAidLayout.performClick();
                    }

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rotate_backward);
                            eorlView.startAnimation(rotate);
                            flag6 = true;
                            expand(eorlText);
                        }
                    }, 301);

                } else {
                    Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.rotate_forward);
                    eorlView.startAnimation(rotate);
                    flag6 = false;
                    collapse(eorlText);
                }
            }
        });

        firstAidLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag7) {


                    // collapse developed text views
                    if (flag) {
                        foreLayout.performClick();
                    }
                    if (flag1) {
                        effectsLayout.performClick();
                    }
                    if (flag2) {
                        principleslayout.performClick();
                    }
                    if (flag3) {
                        clothinglayout.performClick();
                    }
                    if (flag4) {
                        evacuationlayout.performClick();
                    }
                    if (flag5) {
                        fireLayout.performClick();
                    }
                    if (flag6) {
                        eorlLayout.performClick();
                    }

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rotate_backward);
                            firstAidView.startAnimation(rotate);
                            flag7 = true;
                            expand(firstAidText);
                        }
                    }, 301);

                } else {
                    Animation rotate = AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.rotate_forward);
                    firstAidView.startAnimation(rotate);
                    flag7 = false;
                    collapse(firstAidText);
                }
            }
        });

        return root;
    }


    private List<String> setList(List<Substances> substances) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < substances.size(); i++) {
            list.add(substances.get(i).getSubstName());
            list.add(substances.get(i).getOnzNumber());
        }
        return list;
    }

    private boolean isNameExists(String s, List<Substances> list) {
        for (Substances substances : list) {
            if (substances.getSubstName().equals(s))
                return false;
            else break;
        }
        return true;
    }

    public static void expand(final View v) {
        int matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec(((View) v.getParent()).getWidth(), View.MeasureSpec.EXACTLY);
        int wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        v.measure(matchParentMeasureSpec, wrapContentMeasureSpec);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LinearLayout.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // Expansion speed of 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // Collapse speed of 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

}