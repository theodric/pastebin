# IBM 6112884 Japanese layout with Alps switches
# The CPU was removed from the controller board and replaced with a Pro Micro, but the 4 to 16 line decoder remains (hence using muxstrobe).
# http://deskthority.net/post114200.html#p114200
# HaaTa's pics of similar keyboard: http://deskthority.net/post87127.html#p87127

#muxstrobe 2 19 and 5 19 are useless cannot be assigned


matrix
	scanrate 1
	debounce 5
	blocking 0
	muxstrobe_port PF7:4

	#				0			   1			    2				3			        4			    5				6			7
	#			    8	  	       9			    A				B			        C			    D				E			F

	sense		    PD1			    PD0			    PD4				PC6					PD7				PE6				PB4			PB5
	# 0
	muxstrobe 0		back_quote 		TAB				Z			  	S					W				2				UNASSIGNED	UNASSIGNED	
	muxstrobe 1		1				Q			    X			  	D					E				3				UNASSIGNED	UNASSIGNED	
	
	# 1
	muxstrobe 2		LCTRL	  		unassigned		C			  	F					R				4				UNASSIGNED	UNASSIGNED	
	muxstrobe 3		A			    LSHIFT			V			  	G					T				5				UNASSIGNED	UNASSIGNED	
	
	# 2
	muxstrobe 4		esc			    LALT		    B			  	H					Y				6				UNASSIGNED	UNASSIGNED	
	muxstrobe 5		LGUI		    unassigned		N			  	J					U				7				UNASSIGNED	UNASSIGNED	
	
	# 3
	muxstrobe 6		EXTRA_PAD_PLUS 	SPACE		    M				K					I				8				UNASSIGNED	UNASSIGNED	
	muxstrobe 7		RALT		    FN1				COMMA			L					O				9				UNASSIGNED	UNASSIGNED	
	
	# 4
	muxstrobe 8		ENTER		    0		    	PERIOD			SEMICOLON			P				0				UNASSIGNED	UNASSIGNED	
	muxstrobe 9		PAD_PERIOD	    HOME		    SLASH			QUOTE				LEFT_BRACE		MINUS			UNASSIGNED	UNASSIGNED	
	
	# 5
	muxstrobe 10	PAGE_UP			LEFT		  	UNASSIGNED		 	BACKSLASH	  		RIGHT_BRACE		EQUAL			 UNASSIGNED	 UNASSIGNED	
	muxstrobe 11	END		    	EXTRA_F1	  	RSHIFT				ENTER				BACKSLASH		CLEAR_AGAIN		UNASSIGNED	UNASSIGNED	
	
	# 6
	muxstrobe 12	UP	   			PAD_SLASH		D				F					H				backspace		f3	        DOWN
	muxstrobe 13	AUX2			C				1				PAD_MINUS			PAD_ASTERIX    	PAUSE			5		    DELETE	
	
	# 7
	muxstrobe 14	EXSEL			PAD_PLUS		2				4					PAD_PLUS    PRINTSCREEN				7		MEDIA_VOLUME_DOWN	
	muxstrobe 15	PAGE_DOWN		RIGHT			3				6					9			MEDIA_VOLUME_UP			8		MEDIA_MUTE	
	#
end

# need to map the FN key into the base layer (0)

remapblock
	layer 0
		APP FN1
endblock

layerblock
		FN1	1
endblock

remapblock
	layer 1
		MEDIA_VOLUME_DOWN	MEDIA_PREV_TRACK 
		MEDIA_MUTE			MEDIA_PLAY_PAUSE 
		MEDIA_VOLUME_UP		MEDIA_NEXT_TRACK 
		DELETE				INSERT
		1					F1
		2					F2
		3					F3
		4					F4
		5					F5
		6					F6
		7					F7
		8					F8
		9					F9
		0					F10
		MINUS				F11
		EQUAL				F12
		TAB					EXTRA_SYSRQ
		EXSEL				AUX1
		LSHIFT				CAPS_LOCK
endblock

macroblock

macro EXTRA_PAD_PLUS
	PRESS 0
	DELAY 10
	PRESS 0
endmacro

#macro CLEAR_AGAIN
#	PUSH_META CLEAR_META all		
#	SET_META ctrl			
#	PRESS h				
#	POP_META			
#	POP_ALL_META
#endmacro

endblock

macroblock

macro EXTRA_SYSRQ
	PUSH_META CLEAR_META all
	SET_META rgui
	PRESS SPACE
	POP_META
	POP_ALL_META
	DELAY 20
	PRESS l
	DELAY 10
	PRESS o
	DELAY 10
	PRESS c
	DELAY 10
	PRESS k
	DELAY 10
	PRESS s
	DELAY 10
	PRESS c
	DELAY 10
	PRESS r
	DELAY 10
	PRESS e
	DELAY 10
	PRESS e
	DELAY 10
	PRESS n
	DELAY 80
	PRESS enter
endmacro

macro EXSEL 
	PUSH_META CLEAR_META all
	SET_META rgui
	PRESS SPACE
	POP_META
	POP_ALL_META
	DELAY 20
	PRESS d
	DELAY 10
	PRESS o
	DELAY 10
	PRESS n
	DELAY 10
	PRESS QUOTE
	DELAY 10
	PRESS t
	DELAY 10
	PRESS SPACE
	DELAY 10
	PRESS p
	DELAY 10
	PRESS a
	DELAY 10
	PRESS n
	DELAY 10
	PRESS i
	DELAY 10
	PRESS c
	DELAY 10
	PRESS PERIOD
	DELAY 10
	PRESS SPACE
	DELAY 250
	DELAY 250
	DELAY 250
	DELAY 250
	PRESS ESC
	PRESS ESC
endmacro

macro AUX1
	PUSH_META CLEAR_META all
	SET_META rgui
	PRESS SPACE
	POP_META
	POP_ALL_META
	DELAY 10
	TOGGLE_META lshift
	PRESS p
	DELAY 5
	PRESS a
	DELAY 5
	PRESS n
	DELAY 5
	PRESS i
	DELAY 5
	PRESS c
	DELAY 5
	PRESS 1
	DELAY 5
	PRESS 1
	DELAY 5
	PRESS 1
	DELAY 5
	PRESS 1
	DELAY 5
	PRESS 1
	DELAY 5
	PRESS 1
	DELAY 5
	PRESS 1
	PRESS SPACE
	TOGGLE_META lshift
	DELAY 250
	DELAY 250
	PRESS ESC
	PRESS ESC
endmacro

endblock

macroblock

macro AUX2
	PUSH_META CLEAR_META all
	SET_META rgui
	SET_META rctrl
	PRESS f
	POP_META
	POP_ALL_META
endmacro

macro EXTRA_F1
	PUSH_META CLEAR_META all
	SET_META rgui
	PRESS SPACE
	POP_META
	POP_ALL_META
	DELAY 20
	PRESS h
	DELAY 5
	PRESS t
	DELAY 5
	PRESS t
	DELAY 5
	PRESS p
	DELAY 5
	TOGGLE_META lshift
	PRESS SEMICOLON
	DELAY 5
	TOGGLE_META lshift
	PRESS SLASH
	DELAY 5
	PRESS SLASH
	DELAY 5
	PRESS e
	DELAY 5
	PRESS b
	DELAY 5
	PRESS a
	DELAY 5
	PRESS y
	DELAY 5
	PRESS PERIOD
	DELAY 5
	PRESS n
	DELAY 5
	PRESS l
	DELAY 250
	DELAY 250
	DELAY 250
	DELAY 250
	PRESS ENTER
endmacro

endblock
