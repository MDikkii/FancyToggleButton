package com.mdikkii.fancytogglebutton.JellyTypes;

import com.mdikkii.fancytogglebutton.EaseTypes.EaseType;
import com.mdikkii.fancytogglebutton.PointWithHorizontalPoints;
import com.mdikkii.fancytogglebutton.PointWithVerticalPoints;
import com.mdikkii.fancytogglebutton.State;

/**
 * Created by Weiping on 2016/5/11.
 */
public abstract class JellyStyle {

    public abstract void changeShape(
            PointWithHorizontalPoints p1,
            PointWithVerticalPoints p2,
            PointWithHorizontalPoints p3,
            PointWithVerticalPoints p4,
            float stretchDistance,
            float bezierControlValue,
            float bezierScaleRatioValue,
            float thumbRadius,
            float process,
            State state);

    public abstract void changeOffset(
            PointWithHorizontalPoints p1,
            PointWithVerticalPoints p2,
            PointWithHorizontalPoints p3,
            PointWithVerticalPoints p4,
            float totalLength,
            float extractLength,
            float process,
            State state,
            EaseType easeType);

    public abstract float extractLength(
            float stretchDistance,
            float bezierControlValue,
            float bezierScaleRatioValue,
            float thumbRadius);

}
