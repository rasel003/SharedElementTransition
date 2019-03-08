package com.rasel.sharedelementtransition.instagram_sharedElement_Transition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.rasel.sharedelementtransition.R;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

public class BottomSheetDialog extends BottomSheetDialogFragment {
    private BottomSheetListener mListener;

    ImageView imgLoved, imgComment, imgShared, imgSaved;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        ConstraintLayout constraintLayout = v.findViewById(R.id.bottom_sheet_layout);
        imgLoved = v.findViewById(R.id.imgLoved);
        imgComment = v.findViewById(R.id.imgComment);
        imgShared = v.findViewById(R.id.imgShared);
        imgSaved = v.findViewById(R.id.imgSaved);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mListener.onButtonClicked("Button 1 clicked");
                Pair[] pairs = new Pair[4];
                pairs[0] = new Pair<View, String>(imgLoved, "img_transition_love");
                pairs[1] = new Pair<View, String>(imgComment, "img_transition_Comment");
                pairs[2] = new Pair<View, String>(imgShared, "img_transition_Shared");
                pairs[3] = new Pair<View, String>(imgSaved, "img_transition_Saved");

                Intent intent = new Intent(getContext(), ExpandedBottomSheet.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), pairs);
                startActivity(intent, options.toBundle());
                dismiss();
            }
        });
        return v;
    }

    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (BottomSheetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement BottomSheetListener");
        }
    }
}
