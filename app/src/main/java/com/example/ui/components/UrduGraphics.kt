package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.GoldAccent

@Composable
fun MughalHeritageHeroBanner(
    modifier: Modifier = Modifier,
    title: String = "اردو تہذیب و ثقافت",
    subtitle: String = "उर्दू भाषा, इतिहास र समृद्ध परम्परा"
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF044830),
                        Color(0xFF022B1C),
                        Color(0xFF01180F)
                    )
                )
            )
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            // Subtle background Islamic geometric grid
            val starColor = Color(0x18F59E0B)
            for (i in 0..6) {
                drawCircle(
                    color = starColor,
                    radius = 35f,
                    center = Offset(width * (i / 6f), height * 0.35f)
                )
            }

            // Outer Archway
            val archPath = Path().apply {
                moveTo(width * 0.15f, height)
                lineTo(width * 0.15f, height * 0.5f)
                cubicTo(
                    width * 0.15f, height * 0.15f,
                    width * 0.45f, height * 0.05f,
                    width * 0.5f, 0f
                )
                cubicTo(
                    width * 0.55f, height * 0.05f,
                    width * 0.85f, height * 0.15f,
                    width * 0.85f, height * 0.5f
                )
                lineTo(width * 0.85f, height)
            }

            drawPath(
                path = archPath,
                color = Color(0x35F59E0B),
                style = Stroke(width = 4f)
            )

            // Inner Archway accent
            val innerArch = Path().apply {
                moveTo(width * 0.22f, height)
                lineTo(width * 0.22f, height * 0.55f)
                cubicTo(
                    width * 0.22f, height * 0.25f,
                    width * 0.45f, height * 0.18f,
                    width * 0.5f, height * 0.12f
                )
                cubicTo(
                    width * 0.55f, height * 0.18f,
                    width * 0.78f, height * 0.25f,
                    width * 0.78f, height * 0.55f
                )
                lineTo(width * 0.78f, height)
            }
            drawPath(
                path = innerArch,
                color = Color(0x22FBBF24),
                style = Stroke(width = 2.5f)
            )

            // Crescent Moon
            val moonCenter = Offset(width * 0.82f, height * 0.28f)
            drawCircle(
                color = Color(0xFFFDE68A),
                radius = 22f,
                center = moonCenter
            )
            drawCircle(
                color = Color(0xFF044830),
                radius = 18f,
                center = Offset(moonCenter.x - 7f, moonCenter.y - 6f)
            )

            // Shimmering Golden Stars
            val starPositions = listOf(
                Offset(width * 0.18f, height * 0.22f),
                Offset(width * 0.32f, height * 0.18f),
                Offset(width * 0.72f, height * 0.18f),
                Offset(width * 0.88f, height * 0.45f),
                Offset(width * 0.12f, height * 0.42f)
            )
            starPositions.forEach { pos ->
                drawCircle(color = Color(0xFFFDE68A), radius = 3.5f, center = pos)
            }
        }

        // Overlay text
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ",
                fontSize = 14.sp,
                color = GoldAccent.copy(alpha = 0.85f),
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = title,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtitle,
                fontSize = 13.sp,
                color = Color(0xFFE2E8F0),
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
fun CalligraphyArtBadge(
    modifier: Modifier = Modifier,
    char: String = "آ",
    tag: String = "اردو"
) {
    Box(
        modifier = modifier
            .size(72.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF064E3B), Color(0xFF022C22))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color(0x33F59E0B),
                radius = size.minDimension / 2.3f,
                style = Stroke(width = 2f)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = char,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = GoldAccent
            )
            Text(
                text = tag,
                fontSize = 10.sp,
                color = Color.White.copy(alpha = 0.8f)
            )
        }
    }
}

@Composable
fun MushairaLanternGraphic(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF78350F).copy(alpha = 0.15f)),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            val w = size.width
            val h = size.height

            // Lantern roof
            val roof = Path().apply {
                moveTo(w * 0.2f, h * 0.35f)
                lineTo(w * 0.5f, h * 0.1f)
                lineTo(w * 0.8f, h * 0.35f)
                close()
            }
            drawPath(roof, color = Color(0xFFB45309))

            // Body
            drawRect(
                color = Color(0xFFF59E0B).copy(alpha = 0.6f),
                topLeft = Offset(w * 0.25f, h * 0.35f),
                size = Size(w * 0.5f, h * 0.45f)
            )

            // Inner flame glow
            drawCircle(
                color = Color(0xFFFEF08A),
                radius = w * 0.12f,
                center = Offset(w * 0.5f, h * 0.55f)
            )
        }
    }
}
