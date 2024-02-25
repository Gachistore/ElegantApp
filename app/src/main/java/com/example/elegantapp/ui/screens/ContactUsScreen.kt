package com.example.elegantapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.elegantapp.R
import com.example.elegantapp.data.ElegantLists
import com.example.elegantapp.ui.components.Footer
import com.example.elegantapp.ui.components.cards.GrayContactUsCard
import com.example.elegantapp.ui.theme.Black900
import com.example.elegantapp.ui.theme.DrawerSearchIconColor
import com.example.elegantapp.ui.theme.DrawerSearchTextFieldColor
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.Neutral02
import com.example.elegantapp.ui.theme.Neutral04
import com.example.elegantapp.ui.theme.Neutral07
import com.example.elegantapp.ui.theme.Poppins
import com.example.elegantapp.ui.theme.StupidColor

@Composable
fun ContactUsScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(rememberScrollState())
    ) {
        Introduction(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, top = 32.dp, end = 32.dp, bottom = 40.dp)
        )
        AboutUs(
            image = R.drawable.introduction_sofa,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        )
        ContactUs(
            address = "234 Hai Trieu, Ho Chi Minh City," +
                    "Viet Nam",
            phoneNumber = "+84 234 567 890\n",
            email = "hello@3legant.com\n",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp, horizontal = 32.dp)
        )
//        Benefits(
//            benefitsList = ElegantLists.Benefits,
//            modifier = Modifier
//                .padding(dimensionResource(R.dimen.default_32_padding))
//                .background(
//                    Neutral02
//                )
//        )

        Footer(navController = navController)
    }
}

@Composable
private fun Introduction(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "We believe in sustainable decor. We’re passionate about life at home.",
            fontFamily = Poppins,
            fontWeight = FontWeight.W500,
            fontSize = 28.sp,
            lineHeight = 33.sp,
            color = Neutral07
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = "Our features timeless furniture, with natural fabrics, curved lines, plenty of mirrors and classic design, which can be incorporated into any decor project. The pieces enchant for their sobriety, to last for generations, faithful to the shapes of each period, with a touch of the present",
            fontFamily = Inter,
            fontWeight = W400,
            fontSize = 16.sp,
            lineHeight = 25.sp,
            color = Neutral07
        )
    }
}

@Composable
private fun AboutUs(
    @DrawableRes image: Int,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .padding(vertical = 63.5.dp)
                .background(Neutral02)
        ) {
            Text(
                text = "About Us",
                fontFamily = Poppins,
                fontWeight = W500,
                fontSize = 20.sp,
                lineHeight = 28.sp,
                color = Black900
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "3legant is a gift & decorations store based in HCMC, Vietnam. Est since 2019" +
                        "Our customer service is always prepared to support you 24/7",
                fontFamily = Inter,
                fontWeight = W400,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Black900
            )
            Spacer(Modifier.height(24.dp))
            LinkButtonWithArrow(
                text = R.string.shop_now,
                fontSizeSp = 16,
                color = Black900,
                onClick = onClick
            )
        }
    }
}

@Composable
private fun ContactUs(
    address: String,
    phoneNumber: String,
    email: String,
    onClickSendMessage: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    // TODO: переделать в state во viewModel
    var fullNameTextField by remember { mutableStateOf("") }
    var emailAdressTextField by remember { mutableStateOf("") }
    var messageTextField by remember { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.contact_us),
            fontFamily = Poppins,
            fontWeight = W500,
            fontSize = 20.sp,
            lineHeight = 28.sp,
            textAlign = TextAlign.Center,
            color = Black900,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(40.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GrayContactUsCard(
                icon = Icons.Outlined.Storefront,
                title = "Address",
                description = address,
                modifier = Modifier.fillMaxWidth()
            )
            GrayContactUsCard(
                icon = Icons.Outlined.Call,
                title = "Contact Us",
                description = phoneNumber,
                modifier = Modifier.fillMaxWidth()
            )
            GrayContactUsCard(
                icon = Icons.Outlined.Mail,
                title = "Email",
                description = email,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(Modifier.height(40.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column {
                Text(
                    text = stringResource(R.string.full_name),
                    fontFamily = Inter,
                    fontWeight = W700,
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    color = Neutral04
                )
                Spacer(Modifier.height(12.dp))
                OutlinedTextField(
                    value = fullNameTextField,
                    onValueChange = { fullNameTextField = it },
                    label = {
                        Text(
                            text = stringResource(R.string.your_name),
                            fontFamily = Inter,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            color = StupidColor
                        )
                    },
                    prefix = {
                        Spacer(Modifier.width(10.dp))
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Column {
                Text(
                    text = stringResource(R.string.email_address),
                    fontFamily = Inter,
                    fontWeight = W700,
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    color = Neutral04
                )
                Spacer(Modifier.height(12.dp))
                OutlinedTextField(
                    value = emailAdressTextField,
                    onValueChange = { emailAdressTextField = it },
                    label = {
                        Text(
                            text = stringResource(R.string.your_email),
                            fontFamily = Inter,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            color = StupidColor
                        )
                    },
                    prefix = {
                        Spacer(Modifier.width(10.dp))
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Column {
                Text(
                    text = stringResource(R.string.full_name),
                    fontFamily = Inter,
                    fontWeight = W700,
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    color = Neutral04
                )
                Spacer(Modifier.height(12.dp))
                OutlinedTextField(
                    value = messageTextField,
                    onValueChange = { messageTextField = it },
                    label = {
                        Text(
                            text = stringResource(R.string.your_message),
                            fontFamily = Inter,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            color = StupidColor
                        )
                    },
                    prefix = {
                        Spacer(Modifier.width(10.dp))
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    minLines = 4,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Spacer(Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            // TODO: переделать onClick
            Button(
                onClick = {
                    emailAdressTextField = ""
                    fullNameTextField = ""
                    messageTextField = ""
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Neutral07,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = stringResource(R.string.send_message),
                    fontFamily = Inter,
                    fontWeight = W500,
                    fontSize = 16.sp,
                    lineHeight = 26.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ContactUsScreenPreview() {
    val navController: NavHostController = rememberNavController()
    ElegantAppTheme {
        ContactUsScreen(navController = navController)
    }
}