package com.sayatcode.tracker_presentation.tracker_overview.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.sayatcode.core.R
import com.sayatcode.core_ui.LocalSpacing
import com.sayatcode.tracker_presentation.components.NutrientInfo
import com.sayatcode.tracker_presentation.components.UnitDisplay
import com.sayatcode.tracker_presentation.tracker_overview.Meal

@Composable
fun ExpandableMeal(
    meal: Meal,
    onToggleClick:() -> Unit,
    content:@Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{ onToggleClick() }
                .padding(spacing.spaceMedium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(meal.drawableRes),
                contentDescription = meal.name.asString(context)
            )
            Spacer(Modifier.width(spacing.spaceMedium))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = meal.name.asString(context),
                        style = MaterialTheme.typography.h3
                    )
                    Icon(
                        imageVector = if (meal.isExpanded) {
                            Icons.Default.KeyboardArrowUp
                        }else{
                            Icons.Default.KeyboardArrowDown
                        },
                        contentDescription = if(meal.isExpanded) {
                            stringResource(id = R.string.collapse)
                        } else stringResource(id = R.string.extend)
                    )
                }
                Spacer(Modifier.height(spacing.spaceSmall))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    UnitDisplay(
                        amount = meal.calories,
                        unit = stringResource(R.string.kcal),
                        amountTextSize = 30.sp
                    )
                    Row() {
                        NutrientInfo(
                            name = stringResource(R.string.carbs),
                            amount = meal.carbs,
                            unit = stringResource(R.string.grams)
                        )
                        Spacer(Modifier.width(spacing.spaceSmall))
                        NutrientInfo(
                            name = stringResource(R.string.protein),
                            amount = meal.protein,
                            unit = stringResource(R.string.grams)
                        )
                        Spacer(Modifier.width(spacing.spaceSmall))
                        NutrientInfo(
                            name = stringResource(R.string.fat),
                            amount = meal.fat,
                            unit = stringResource(R.string.grams)
                        )
                    }
                }
            }
        }
    }
}