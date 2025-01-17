package edu.cc231008.bookstoreapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import edu.cc231008.bookstoreapp.data.db.CommentEntity
import edu.cc231008.bookstoreapp.ui.AppViewModelProvider
import edu.cc231008.bookstoreapp.ui.EditCommentViewModel

@Composable
fun EditCommentScreen(
    commentId: String,
    navController: NavHostController,
    editCommentViewModel: EditCommentViewModel = viewModel(factory = AppViewModelProvider.editCommentFactory),
) {

    val comment by editCommentViewModel.comment.collectAsStateWithLifecycle()
    var commentText by remember {mutableStateOf("")}

    LaunchedEffect(comment) {
        commentText = comment?.comment ?: ""
    }

    Column {
        TextField(
            value = commentText,
            onValueChange = { commentText = it }
        )
        Button(onClick = {
            comment?.let {
                editCommentViewModel.editComment(
                    CommentEntity(
                        id = commentId.toInt(),
                        isbn13 = comment!!.isbn13,
                        comment = commentText
                    )
                )
                navController.previousBackStackEntry?.savedStateHandle?.set("commentEdited", true)
                navController.popBackStack()
            }
        }) {
            Text("Save")
        }
    }
}
