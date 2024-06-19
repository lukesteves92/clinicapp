package com.inspirecoding.clinicapp.commons.mapping

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import com.inspirecoding.clinicapp.commons.constants.Constants.Arrangement.KEY_CENTER_ARRANGEMENT
import com.inspirecoding.clinicapp.commons.constants.Constants.Arrangement.KEY_SPACE_AROUND
import com.inspirecoding.clinicapp.commons.constants.Constants.Arrangement.KEY_SPACE_BETWEEN
import com.inspirecoding.clinicapp.commons.constants.Constants.Arrangement.KEY_SPACE_EVENLY
import com.inspirecoding.clinicapp.commons.constants.Constants.HorizontalAlignment.KEY_HORIZONTAL_CENTER
import com.inspirecoding.clinicapp.commons.constants.Constants.HorizontalAlignment.KEY_HORIZONTAL_END
import com.inspirecoding.clinicapp.commons.constants.Constants.HorizontalAlignment.KEY_HORIZONTAL_START
import com.inspirecoding.clinicapp.commons.constants.Constants.VerticalAlignment.KEY_VERTICAL_BOTTOM
import com.inspirecoding.clinicapp.commons.constants.Constants.VerticalAlignment.KEY_VERTICAL_CENTER
import com.inspirecoding.clinicapp.commons.constants.Constants.VerticalAlignment.KEY_VERTICAL_TOP
import com.inspirecoding.clinicapp.commons.models.domain.bottom.BottomModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.button.ButtonModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.column.ColumnModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.divider.DividerModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.fields.FieldsModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.image.ImageModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.row.RowModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.screen.ScreenModelDomain
import com.inspirecoding.clinicapp.commons.models.remote.bottom.BottomModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.button.ButtonModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.column.ColumnModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.divider.DividerModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.fields.FieldsModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.image.ImageModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.row.RowModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.screen.ScreenModelRemote

fun ButtonModelRemote.mapToDomain() = ButtonModelDomain(
    label = this.label,
    redirect = this.redirect,
    spacer = this.spacer
)

fun DividerModelRemote.mapToDomain() = DividerModelDomain(
    spacer = this.spacer
)

fun FieldsModelRemote.mapToDomain() = FieldsModelDomain(
    spacer = this.spacer,
    firstLabel = this.firstLabel,
    secondLabel = this.secondLabel
)

fun ImageModelRemote.mapToDomain() = ImageModelDomain(
    spacer = this.spacer,
    height = this.height,
    value = this.value
)

fun BottomModelRemote.mapToDomain() = BottomModelDomain(
    firstLabel = this.firstLabel,
    redirect = this.redirect,
    secondLabel = this.secondLabel,
    verticalAlignment = this.verticalAlignment.convertVerticalAlignment()
)

fun ColumnModelRemote.mapToDomain() = ColumnModelDomain(
    padding = this.padding,
    horizontalAlignment = this.horizontalAlignment.convertHorizontalAlignment(),
    verticalArrangement = this.verticalArrangement.convertArrangement()
)

fun RowModelRemote.mapToDomain() = RowModelDomain(
    checkboxLabel = this.checkboxLabel,
    firstLabel = this.firstLabel,
    spacer = this.spacer,
    horizontalArrangement = this.horizontalArrangement.convertArrangement(),
    verticalAlignment = this.verticalAlignment.convertVerticalAlignment()
)

fun ScreenModelRemote.mapToDomain() = ScreenModelDomain(
    bottomModelDomain = this.bottomModelRemote.mapToDomain(),
    buttonModelDomain = this.buttonModelRemote.mapToDomain(),
    columnModelDomain = this.columnModelRemote.mapToDomain(),
    dividerModelDomain = this.dividerModelRemote.mapToDomain(),
    fieldsModelDomain = this.fieldsModelRemote.mapToDomain(),
    imageModelDomain = this.imageModelRemote.mapToDomain(),
    rowModelDomain = this.rowModelRemote.mapToDomain()
)

fun String.convertArrangement(): Arrangement.HorizontalOrVertical =
    when (this) {
        KEY_SPACE_EVENLY -> Arrangement.SpaceEvenly
        KEY_SPACE_AROUND -> Arrangement.SpaceAround
        KEY_SPACE_BETWEEN -> Arrangement.SpaceBetween
        KEY_CENTER_ARRANGEMENT -> Arrangement.Center
        else -> Arrangement.Center
    }

fun String.convertVerticalAlignment(): Alignment.Vertical =
    when (this) {
        KEY_VERTICAL_TOP -> Alignment.Top
        KEY_VERTICAL_BOTTOM -> Alignment.Bottom
        KEY_VERTICAL_CENTER -> Alignment.CenterVertically
        else -> Alignment.CenterVertically
    }

fun String.convertHorizontalAlignment(): Alignment.Horizontal =
    when (this) {
        KEY_HORIZONTAL_END -> Alignment.End
        KEY_HORIZONTAL_START -> Alignment.Start
        KEY_HORIZONTAL_CENTER -> Alignment.CenterHorizontally
        else -> Alignment.CenterHorizontally
    }