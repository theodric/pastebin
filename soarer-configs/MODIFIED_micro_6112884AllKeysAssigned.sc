# IBM 6112884 Japanese layout with Alps switches
# The CPU was removed from the controller board and replaced with a Teensy, but the 4 to 16 line decoder remains (hence using muxstrobe).
# http://deskthority.net/post114200.html#p114200
# HaaTa's pics of similar keyboard: http://deskthority.net/post87127.html#p87127

#muxstrobe 10 3b changed from back_quote to backspace
#muxstrobe 7 19 changed from App to RGUI
#muxstrobe 0 08 changed from esc to page_down
#muxstrobe 12 5D changed from backspace to back_quote
#muxstrobe 10 2a changed from international_1 (ro, also scancode 073, the Japanese key next to rshift) to rshift so I now have two rshifts
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
	muxstrobe 6		EXTRA_INSERT   	SPACE		    M				K					I				8				UNASSIGNED	UNASSIGNED	
	muxstrobe 7		RALT		    rgui			COMMA			L					O				9				UNASSIGNED	UNASSIGNED	
	
	# 4
	muxstrobe 8		esc		    	0		    	PERIOD			SEMICOLON			P				0				UNASSIGNED	UNASSIGNED	
	muxstrobe 9		PAD_PERIOD	    HOME		    slash			QUOTE				LEFT_BRACE		MINUS			UNASSIGNED	UNASSIGNED	
	
	# 5
	muxstrobe 10	PAGE_UP			LEFT		  	rshift		  	back_quote	  		RIGHT_BRACE		EQUAL			 UNASSIGNED	 UNASSIGNED	
	muxstrobe 11	END		    	PAD_6		  	RSHIFT			ENTER				BACKSLASH		esc				UNASSIGNED	UNASSIGNED	
	
	# 6
	muxstrobe 12	UP	   			B				D				F					H				backspace		f3	        DOWN
	muxstrobe 13	A				C				1				G					I		    	PAD_SLASH		5		f8	
	
	# 7
	muxstrobe 14	PAD_MINUS		PAD_PLUS		2				4					Q		    R						7		MEDIA_MUTE	
	muxstrobe 15	PAGE_DOWN		RIGHT			3				6					9			MEDIA_VOLUME_UP			8		MEDIA_VOLUME_DOWN	
	#
end


macroblock

macro EXTRA_INSERT
	PRESS 0
	PRESS 0
endmacro

macro F7
	PRESS f
	PRESS 7
endmacro

macro f8
	PRESS f
	PRESS 8
endmacro


macro f9
	PRESS f
	PRESS 9
endmacro

macro f10
	PRESS f
	PRESS 1
	PRESS 0
endmacro

macro f11
	PRESS f
	PRESS 1
	PRESS 1
endmacro

macro SLASH ctrl
	PRESS MEDIA_CALCULATOR		
endmacro

macro M ctrl				
	PRESS MEDIA_MUTE		
endmacro

macro insert
	PRESS i
	PRESS n
	PRESS s
endmacro

endblock



macroblock

macro pad_0
		
endmacro


macro pad_4

endmacro


macro pad_5

endmacro

macro pad_6

endmacro

macro pad_7

endmacro


endblock
