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
	muxstrobe 7		RALT		    FN1			COMMA			L					O				9				UNASSIGNED	UNASSIGNED	
	
	# 4
	muxstrobe 8		ENTER		    	0		    	PERIOD			SEMICOLON			P				0				UNASSIGNED	UNASSIGNED	
	muxstrobe 9		PAD_PERIOD	    HOME		    slash			QUOTE				LEFT_BRACE		MINUS			UNASSIGNED	UNASSIGNED	
	
	# 5
	muxstrobe 10	PAGE_UP			LEFT		  	rshift		  	back_quote	  		RIGHT_BRACE		EQUAL			 UNASSIGNED	 UNASSIGNED	
	muxstrobe 11	END		    	PAD_6		  	RSHIFT			ENTER				BACKSLASH		CLEAR_AGAIN		UNASSIGNED	UNASSIGNED	
	
	# 6
	muxstrobe 12	UP	   			B				D				F					H				backspace		f3	        DOWN
	muxstrobe 13	A				C				1				G					I		    	PAD_SLASH		5		    DELETE	
	
	# 7
	muxstrobe 14	PAD_MINUS		PAD_PLUS		2				4					Q		    R						7		MEDIA_VOLUME_DOWN	
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
		ENTER				EXTRA_SYSRQ
endblock

macroblock

macro EXTRA_PAD_PLUS
	PRESS 0
	DELAY 10
	PRESS 0
endmacro

macro CLEAR_AGAIN
	PUSH_META CLEAR_META all		
	SET_META ctrl			
	PRESS h				
	POP_META			
	POP_ALL_META
endmacro

endblock

macroblock

macro EXTRA_SYSRQ
	PUSH_META CLEAR_META all
	SET_META rgui
	PRESS SPACE
	POP_META
	POP_ALL_META
	PRESS l
	DELAY 20
	PRESS o
	DELAY 20
	PRESS c
	DELAY 20
	PRESS k
	DELAY 20
	PRESS s
	DELAY 20
	PRESS c
	DELAY 20
	PRESS r
	DELAY 20
	PRESS e
	DELAY 20
	PRESS e
	DELAY 20
	PRESS n
	DELAY 80
	PRESS enter
endmacro

endblock