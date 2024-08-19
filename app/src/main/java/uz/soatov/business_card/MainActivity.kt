package uz.soatov.business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import uz.soatov.business_card.ui.theme.Business_cardTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			Business_cardTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					BusinessCard(
						modifier = Modifier
							.padding(innerPadding)
							.padding(vertical = 16.dp)
					)
				}
			}
		}
	}
}


@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceBetween,
		modifier = modifier.fillMaxSize()
	) {
		Profile(
			modifier
				.fillMaxWidth()
		)
		ContactInfo(
			phoneNumber = "+99 589 58 50",
			email = "svkhrobbeck@gmail.com",
			website = "www.soatov.uz",
		)
	}
}

@Composable
fun Profile(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier.fillMaxWidth(),
		verticalArrangement = Arrangement.spacedBy(16.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		ProfileImage()
		ProfileInfo(name = "Suhrobbek Soatov", label = "Android Developer")
	}
}

@Composable
fun GetImage(painter: Painter, alt: String, modifier: Modifier = Modifier) {
	Image(
		painter = painter, contentDescription = alt, modifier = modifier
	)
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
	val painter = painterResource(id = R.drawable.profile)

	GetImage(
		painter = painter, alt = "my photo", modifier = modifier
			.clip(
				CircleShape
			)
			.size(240.dp)
	)
}

@Composable
fun ProfileInfo(name: String, label: String, modifier: Modifier = Modifier) {
	Column(modifier = modifier.fillMaxWidth()) {
		Text(
			text = name,
			fontSize = 36.sp,
			fontWeight = FontWeight.Bold,
			lineHeight = 42.sp,
			textAlign = TextAlign.Center,
			modifier = modifier.fillMaxWidth()
		)
		Text(
			text = label,
			fontSize = 22.sp,
			lineHeight = 30.sp,
			fontWeight = FontWeight.SemiBold,
			color = Color(0xFFFF9900),
			textAlign = TextAlign.Center,
			modifier = modifier.fillMaxWidth()
		)
	}
}

@Composable
fun ContactInfo(
	phoneNumber: String,
	email: String,
	website: String,
	modifier: Modifier = Modifier,
) {
	Column(
		verticalArrangement = Arrangement.spacedBy(10.dp),
		modifier = modifier.fillMaxWidth(0.7F)
	) {
		val phonePainter = painterResource(id = R.drawable.phone)
		val mailPainter = painterResource(id = R.drawable.mail)
		val laptopPainter = painterResource(id = R.drawable.laptop)
		Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
			GetImage(
				painter = phonePainter,
				alt = "phone",
				modifier.size(24.dp)
			)
			Text(
				text = phoneNumber,
				fontSize = 16.sp,
				lineHeight = 24.sp,
				fontWeight = FontWeight.SemiBold,
			)
		}
		Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
			GetImage(
				painter = mailPainter,
				alt = "phone",
				modifier.size(24.dp)
			)
			Text(
				text = email,
				fontSize = 16.sp,
				lineHeight = 24.sp,
				fontWeight = FontWeight.SemiBold,
			)
		}
		Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)){
			GetImage(
				painter = laptopPainter,
				alt = "phone", modifier.size(24.dp)
			)
			Text(
				text = website,
				fontSize = 16.sp,
				lineHeight = 24.sp,
				fontWeight = FontWeight.SemiBold,
			)
		}

	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
	BusinessCard(Modifier.padding(top = 16.dp))
}