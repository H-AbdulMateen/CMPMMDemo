package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.presentation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import cmpmmdemo.feature.auth.generated.resources.Res
import cmpmmdemo.feature.auth.generated.resources.login
import cmpmmdemo.feature.auth.generated.resources.password
import cmpmmdemo.feature.auth.generated.resources.username
import com.abdulmateen.cmpmmdemo.core.common.presentation.UiText
import com.abdulmateen.cmpmmdemo.core.ui.components.ErrorAlertDialog
import com.abdulmateen.cmpmmdemo.core.ui.components.LogoImage
import com.abdulmateen.cmpmmdemo.core.ui.components.OutlinedTF
import com.abdulmateen.cmpmmdemo.core.ui.components.OutlinedTFPassword
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreenRoot(
    onLoginSuccess: () -> Unit
){
    val viewModel: LoginViewModel = koinViewModel()
    LoginScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        uiAction = viewModel::uiAction,
        onLoginSuccess = onLoginSuccess
    )
}

@Composable
fun LoginScreen(
    uiState: LoginUiState,
    uiAction: (LoginUiAction) -> Unit,
    onLoginSuccess: () -> Unit,
) {
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState
            )
        }
    ) {innerPadding ->
        LaunchedEffect(key1 = uiState.navigateToMain){
            if (uiState.navigateToMain){
               onLoginSuccess()
            }

        }

        Box(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ){
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                LogoImage(modifier = Modifier.size(120.dp))
                Spacer(modifier = Modifier.height(32.dp))

                OutlinedCard {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = stringResource(resource = Res.string.login),
                            style = MaterialTheme.typography.displayMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedTF(
                            value = uiState.username,
                            onValueChange = { uiAction(LoginUiAction.UpdateUsername(it)) },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = stringResource(resource = Res.string.username)
                        )
                        OutlinedTFPassword(
                            value = uiState.password,
                            onValueChange = { uiAction(LoginUiAction.UpdatePassword(it)) },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = stringResource(resource = Res.string.password),
                            hasError = uiState.hasPasswordError,
                            errorMessage = uiState.passwordErrorMessage,
                            visibility = uiState.passwordVisibility,
                            toggleVisibility = { uiAction(LoginUiAction.TogglePasswordVisibility) }
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
//                            onClick = { onLoginSuccess() }
                            onClick = { uiAction(LoginUiAction.OnLoginClicked)}
                        ){
                            Text(text = stringResource(resource = Res.string.login))
                        }

                    }
                }


            }
            if (uiState.isLoading){
                CircularProgressIndicator(
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }
        }
        if (uiState.isAlertDialogOpened){
            ErrorAlertDialog(
                onDismissRequest = { uiAction(LoginUiAction.ToggleAlertDialog) },
                onConfirmation = { uiAction(LoginUiAction.ToggleAlertDialog) },
                dialogTitle = "Error",
                dialogText = uiState.errorMessage.asString()
            )
        }

    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        uiState = LoginUiState(),
        uiAction = {},
        onLoginSuccess = {}
    )
}

