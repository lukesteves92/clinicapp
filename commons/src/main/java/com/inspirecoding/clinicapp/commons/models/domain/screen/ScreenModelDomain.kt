package com.inspirecoding.clinicapp.commons.models.domain.screen

import android.os.Parcelable
import com.inspirecoding.clinicapp.commons.models.domain.bottom.BottomModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.button.ButtonModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.column.ColumnModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.divider.DividerModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.fields.FieldsModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.image.ImageModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.row.RowModelDomain
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScreenModelDomain(
    val bottomModelDomain: BottomModelDomain,
    val buttonModelDomain: ButtonModelDomain,
    val columnModelDomain: ColumnModelDomain,
    val dividerModelDomain: DividerModelDomain,
    val fieldsModelDomain: FieldsModelDomain,
    val imageModelDomain: ImageModelDomain,
    val rowModelDomain: RowModelDomain
) : Parcelable