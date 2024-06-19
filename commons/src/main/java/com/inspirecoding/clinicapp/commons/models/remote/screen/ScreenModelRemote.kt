package com.inspirecoding.clinicapp.commons.models.remote.screen

import com.google.gson.annotations.SerializedName
import com.inspirecoding.clinicapp.commons.models.remote.bottom.BottomModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.button.ButtonModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.column.ColumnModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.divider.DividerModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.fields.FieldsModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.image.ImageModelRemote
import com.inspirecoding.clinicapp.commons.models.remote.row.RowModelRemote

data class ScreenModelRemote(
    @SerializedName("bottom")
    val bottomModelRemote: BottomModelRemote,
    @SerializedName("button")
    val buttonModelRemote: ButtonModelRemote,
    @SerializedName("column")
    val columnModelRemote: ColumnModelRemote,
    @SerializedName("divider")
    val dividerModelRemote: DividerModelRemote,
    @SerializedName("fields")
    val fieldsModelRemote: FieldsModelRemote,
    @SerializedName("image")
    val imageModelRemote: ImageModelRemote,
    @SerializedName("row")
    val rowModelRemote: RowModelRemote
)