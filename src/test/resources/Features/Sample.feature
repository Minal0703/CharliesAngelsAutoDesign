Feature: Send OTP to user for successfully app registration

Scenario: Verify error message when user enters invalid phone no.
	Given Browser is opened and URL is launched completely
	When User enters invalid phone number
	Then User should get error message