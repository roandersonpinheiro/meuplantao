

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.meuplantao.util.extensions.Patterns
import com.meuplantao.util.extensions.contrastColor
import com.meuplantao.util.extensions.toColor


/**
 * Color strings should be formatted as hex color values (#000000)
 **/
@Composable
fun ColorPickerDialog(
    initialColor: String,
    colors: List<String>,
    onChoice: (String) -> Unit
) {
    var color by remember(initialColor) { mutableStateOf(initialColor) }
    var hexTextColor by remember(initialColor) {
        mutableStateOf(initialColor.toColor(Color.White).contrastColor())
    }

    val colorRendered by animateColorAsState(
        targetValue = color.toColor(Color.White),
        finishedListener = {
            hexTextColor = it.contrastColor()
        }
    )

    val onDismissRequest = {
        if (Patterns.color.matches(color)) {
            onChoice(color)
        }
    }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        buttons = {
            Surface(
                shape = MaterialTheme.shapes.medium
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    BasicTextField(
                        value = color,
                        onValueChange = {
                            color = it
                        },
                        textStyle = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center,
                            color = hexTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(colorRendered)
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Column(
                        modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                    ) {
                        LazyVerticalGrid(
                            columns = GridCells.Adaptive(minSize = 50.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                        ) {
                            items(colors) {
                                Button(
                                    onClick = { color = it },
                                    shape = CircleShape,
                                    modifier = Modifier.requiredSize(50.dp),
                                    contentPadding = PaddingValues(1.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = it.toColor(Color.Transparent)
                                    ),
                                    border = if (it == color)
                                        BorderStroke(2.dp, MaterialTheme.colors.onSurface)
                                    else
                                        null,
                                    content = {}
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        TextButton(onClick = onDismissRequest, modifier = Modifier.align(Alignment.End)) {
                            Text(text = "Confirm", style = MaterialTheme.typography.button)
                        }
                    }
                }
            }
        }
    )
}
