package com.example.ak7mt_zaluda_radim_movieapp.movieList.views

sealed interface MovieListUiEvent {
    data class Paging(val category: String) : MovieListUiEvent
    object Navigate : MovieListUiEvent
}

