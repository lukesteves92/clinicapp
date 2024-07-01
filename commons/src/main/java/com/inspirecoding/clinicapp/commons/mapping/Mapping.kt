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
import com.inspirecoding.clinicapp.commons.models.domain.navigation.items.NavigationItemsModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.navigation.main.NavigationModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.row.RowModelDomain
import com.inspirecoding.clinicapp.commons.models.domain.screen.ScreenModelDomain
import com.inspirecoding.clinicapp.commons.models.remote.bottom.BottomModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.button.ButtonModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.column.ColumnModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.divider.DividerModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.fields.FieldsModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.image.ImageModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.navigation.items.NavigationItemsModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.navigation.main.NavigationModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.row.RowModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.screen.ScreenModelResponse

fun ButtonModelResponse.mapToDomain() = ButtonModelDomain(
    label = this.label,
    redirect = this.redirect,
    spacer = this.spacer
)

fun DividerModelResponse.mapToDomain() = DividerModelDomain(
    spacer = this.spacer
)

fun FieldsModelResponse.mapToDomain() = FieldsModelDomain(
    spacer = this.spacer,
    firstLabel = this.firstLabel,
    secondLabel = this.secondLabel
)

fun ImageModelResponse.mapToDomain() = ImageModelDomain(
    spacer = this.spacer,
    height = this.height,
    value = this.value
)

fun BottomModelResponse.mapToDomain() = BottomModelDomain(
    firstLabel = this.firstLabel,
    redirect = this.redirect,
    secondLabel = this.secondLabel,
    verticalAlignment = this.verticalAlignment.convertVerticalAlignment()
)

fun ColumnModelResponse.mapToDomain() = ColumnModelDomain(
    padding = this.padding,
    horizontalAlignment = this.horizontalAlignment.convertHorizontalAlignment(),
    verticalArrangement = this.verticalArrangement.convertArrangement()
)

fun RowModelResponse.mapToDomain() = RowModelDomain(
    checkboxLabel = this.checkboxLabel,
    firstLabel = this.firstLabel,
    spacer = this.spacer,
    horizontalArrangement = this.horizontalArrangement.convertArrangement(),
    verticalAlignment = this.verticalAlignment.convertVerticalAlignment()
)

fun NavigationModelResponse.mapToDomain() = NavigationModelDomain(
    spacer = this.spacer,
    navigationItems = this.navigationItems.map { it.mapToDomain() }
)

fun NavigationItemsModelResponse.mapToDomain() = NavigationItemsModelDomain(
    name = this.name,
    redirectTo = this.redirectTo
)

fun ScreenModelResponse.mapToDomain() = ScreenModelDomain(
    bottomModelDomain = this.bottomModelResponse.mapToDomain(),
    buttonModelDomain = this.buttonModelResponse.mapToDomain(),
    columnModelDomain = this.columnModelResponse.mapToDomain(),
    dividerModelDomain = this.dividerModelResponse.mapToDomain(),
    fieldsModelDomain = this.fieldsModelResponse.mapToDomain(),
    imageModelDomain = this.imageModelResponse.mapToDomain(),
    rowModelDomain = this.rowModelResponse.mapToDomain(),
    navigationModelDomain = this.navigationModelResponse.mapToDomain()
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