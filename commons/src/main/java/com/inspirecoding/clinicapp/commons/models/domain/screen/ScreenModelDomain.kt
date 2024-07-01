package com.inspirecoding.clinicapp.commons.models.domain.screen

import android.os.Parcelable
import com.inspirecoding.clinicapp.commons.models.domain.bottom.BottomModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.button.ButtonModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.column.ColumnModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.divider.DividerModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.fields.FieldsModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.image.ImageModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.navigation.main.NavigationModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.row.RowModelDomain
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ScreenModelDomain(
    val bottomModelDomain: BottomModelDomain = BottomModelDomain(),
    val buttonModelDomain: ButtonModelDomain = ButtonModelDomain(),
    val columnModelDomain: ColumnModelDomain = ColumnModelDomain(),
    val dividerModelDomain: DividerModelDomain = DividerModelDomain(),
    val fieldsModelDomain: FieldsModelDomain = FieldsModelDomain(),
    val imageModelDomain: ImageModelDomain = ImageModelDomain(),
    val rowModelDomain: RowModelDomain = RowModelDomain(),
    val navigationModelDomain: @RawValue NavigationModelDomain = NavigationModelDomain()
) : Parcelable