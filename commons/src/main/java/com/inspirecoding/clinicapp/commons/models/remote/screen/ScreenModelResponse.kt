package com.inspirecoding.clinicapp.commons.models.remote.screen

import com.google.gson.annotations.SerializedName
import com.inspirecoding.clinicapp.commons.models.remote.bottom.BottomModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.button.ButtonModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.column.ColumnModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.divider.DividerModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.fields.FieldsModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.image.ImageModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.navigation.main.NavigationModelResponse
import com.inspirecoding.clinicapp.commons.models.remote.row.RowModelResponse

data class ScreenModelResponse(
    @SerializedName("bottom")
    val bottomModelResponse: BottomModelResponse,
    @SerializedName("button")
    val buttonModelResponse: ButtonModelResponse,
    @SerializedName("column")
    val columnModelResponse: ColumnModelResponse,
    @SerializedName("divider")
    val dividerModelResponse: DividerModelResponse,
    @SerializedName("fields")
    val fieldsModelResponse: FieldsModelResponse,
    @SerializedName("image")
    val imageModelResponse: ImageModelResponse,
    @SerializedName("row")
    val rowModelResponse: RowModelResponse,
    @SerializedName("navigation")
    val navigationModelResponse: NavigationModelResponse
)