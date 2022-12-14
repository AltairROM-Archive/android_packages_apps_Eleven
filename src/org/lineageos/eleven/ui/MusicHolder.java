/*
 * Copyright (C) 2012 Andrew Neal
 * Copyright (C) 2014 The CyanogenMod Project
 * Copyright (C) 2019-2021 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lineageos.eleven.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.lineageos.eleven.R;
import org.lineageos.eleven.widgets.PlayPauseButtonContainer;
import org.lineageos.eleven.widgets.PopupMenuButton;

import java.lang.ref.WeakReference;

/**
 * Used to efficiently cache and recyle the {@link View}s used in the artist,
 * album, song, playlist, and genre adapters.
 *
 * @author Andrew Neal (andrewdneal@gmail.com)
 */
public class MusicHolder extends RecyclerView.ViewHolder {

    /**
     * This is the artist or album image
     */
    public final WeakReference<ImageView> mImage;

    /**
     * This is the first line displayed in the list or grid
     *
     * see getView() of a specific adapter for more detailed info
     */
    public final WeakReference<TextView> mLineOne;

    /**
     * This is displayed on the right side of the first line in the list or grid
     *
     * see getView() of a specific adapter for more detailed info
     */
    public final WeakReference<TextView> mLineOneRight;

    /**
     * This is the second line displayed in the list or grid
     *
     * see getView() of a specific adapter for more detailed info
     */
    public final WeakReference<TextView> mLineTwo;

    /**
     * The container for the circular progress bar and play/pause button
     *
     * see getView() of a specific adapter for more detailed info
     */
    public final WeakReference<PlayPauseButtonContainer> mPlayPauseProgressButton;

    /**
     * The Padding container for the circular progress bar
     */
    public final WeakReference<View> mPlayPauseProgressContainer;

    /**
     * The song indicator for the currently playing track
     */
    public final WeakReference<View> mNowPlayingIndicator;

    /**
     * The divider for the list item
     */
    public final WeakReference<View> mDivider;

    /**
     * The divider for the list item
     */
    public final WeakReference<PopupMenuButton> mPopupMenuButton;

    /**
     * Constructor of <code>ViewHolder</code>
     */
    public MusicHolder(final View view) {
        super(view);
        // Initialize mImage
        mImage = new WeakReference<>(view.findViewById(R.id.image));

        // Initialize mLineOne
        mLineOne = new WeakReference<>(view.findViewById(R.id.line_one));

        // Initialize mLineOneRight
        mLineOneRight = new WeakReference<>(view.findViewById(R.id.line_one_right));

        // Initialize mLineTwo
        mLineTwo = new WeakReference<>(view.findViewById(R.id.line_two));

        // Initialize Circular progress bar container
        mPlayPauseProgressButton = new WeakReference<>(
                view.findViewById(R.id.playPauseProgressButton));

        // Get the padding container for the progress bar
        mPlayPauseProgressContainer = new WeakReference<>(
                view.findViewById(R.id.play_pause_container));

        mNowPlayingIndicator = new WeakReference<>(view.findViewById(R.id.now_playing));

        // Get the divider for the list item
        mDivider = new WeakReference<>(view.findViewById(R.id.divider));

        // Get the pop up menu button
        mPopupMenuButton = new WeakReference<>(
                view.findViewById(R.id.popup_menu_button));
    }

    public final static class DataHolder {

        /**
         * This is the ID of the item being loaded in the adapter
         */
        public long itemId;

        /**
         * This is the first line displayed in the list or grid
         *
         * see getView() of a specific adapter for more detailed info
         */
        public String lineOne;

        /**
         * This is displayed on the right side of the first line in the list or grid
         *
         * see getView() of a specific adapter for more detailed info
         */
        public String lineOneRight;

        /**
         * This is the second line displayed in the list or grid
         *
         * see getView() of a specific adapter for more detailed info
         */
        public String lineTwo;

        /**
         * Constructor of <code>DataHolder</code>
         */
        public DataHolder() {
            super();
        }
    }
}
