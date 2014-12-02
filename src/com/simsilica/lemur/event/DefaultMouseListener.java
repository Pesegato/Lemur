/*
 * $Id$
 *
 * Copyright (c) 2012-2012 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.simsilica.lemur.event;

import com.jme3.input.event.*;
import com.jme3.scene.*;


/**
 *  A default implementation mouse listener that provides default
 *  implementations for all MouseListener methods.  In addition,
 *  the mouseButtonEvent() provides basic default click behavior
 *  calling an overridable click() method.
 *
 *  @author    Paul Speed
 */
public class DefaultMouseListener implements MouseListener {

    private int xDown;
    private int yDown;

    public DefaultMouseListener() {
    }

    protected void click( MouseButtonEvent event, Spatial target, Spatial capture ) {
    } 

    public void mouseButtonEvent( MouseButtonEvent event, Spatial target, Spatial capture ) {
        event.setConsumed();

        if( event.isPressed() ) {
            xDown = event.getX();
            yDown = event.getY();
        } else {
            int x = event.getX();
            int y = event.getY();
            if( Math.abs(x-xDown) < 3 && Math.abs(y-yDown) < 3 ) {
                click(event, target, capture);
            }
        }
    }

    public void mouseEntered( MouseMotionEvent event, Spatial target, Spatial capture ) {
    }

    public void mouseExited( MouseMotionEvent event, Spatial target, Spatial capture ) {
    }

    public void mouseMoved( MouseMotionEvent event, Spatial target, Spatial capture ) {
    }
}

