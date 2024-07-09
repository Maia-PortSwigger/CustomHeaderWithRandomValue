Custom Header With Random Value
============================

###### Uses session handling rules to add a custom header with a random value to outgoing requests.

 ---
Compatible with Burp Suite Enterprise Edition

Please note that extensions are written by third party users of Burp, and PortSwigger makes no warranty about their quality or usefulness for any particular purpose.

---
## Usage
1. Customise the header name using the HEADER_NAME variable if required. The default name is "UUID".
2. Build the extension
3. [Add the extension to the Burp Suite Enterprise Edition extension library](https://portswigger.net/burp/documentation/enterprise/user-guide/extensions), and add the extension to your required Site.
4. [Configure your session handling rule](#configuring-your-session-handling-rule-in-burp-suite-professionalcommunity) in Burp Suite Professional to invoke the extension, using the required extension action handler and scope. An example session handling rule for the "Custom Header Action - Random UUID Value" action has been included for reference. 
5. Import the session handling rule as a [scan configuration](https://portswigger.net/burp/documentation/enterprise/user-guide/working-with-sites/site-settings/scan-configurations#importing-scan-configurations) into Burp Suite Enterprise Edition and add the scan configuration to your required site.


### Configuring your session handling rule in Burp Suite Professional/Community
1. Load the extension into `Extensions > Installed > Add`
2. Go to `Settings > Search > Sessions`
3. Under `Session handling rules`, go to `Add > Rule actions > Add > Invoke a Burp extension`, select the required `Custom Header Action` option from the extension action handler dropdown list and click `OK`
4. Set your Rule description
5. Click across to the `Scope` tab, ensuring that the `Tools scope > Scanner` box is checked
6. Configure your URL scope appropriately
7. Click `OK`
8. Go to `Extensions > Installed` and reload the extension (uncheck the "Loaded" checkbox, and click it again)
9. Perform any testing in Burp Suite Professional/Community
10. Export the session handling rule by going to `Session handling rules > Cog button > Save settings`


### Example session handling scan configuration JSON
```json
{
    "project_options":{
        "sessions":{
            "session_handling_rules":{
                "rules":[
                    {
                        "actions":[
                            {
                                "action_name":"Custom Header Action - Random UUID Value",
                                "enabled":true,
                                "type":"invoke_extension"
                            }
                        ],
                        "description":"Add UUID header to requests",
                        "enabled":true,
                        "exclude_from_scope":[],
                        "include_in_scope":[],
                        "named_params":[],
                        "restrict_scope_to_named_params":false,
                        "tools_scope":[
                            "Scanner"
                        ],
                        "url_scope":"all",
                        "url_scope_advanced_mode":false
                    }
                ]
            }
        }
    }
}
```

## Troubleshooting
We recommend testing this extension in Burp Suite Professional/Community Edition before using in Burp Suite Enterprise Edition.

To test this extension in Burp Suite Enterprise Edition, you can configure an upstream proxy through Burp Suite Professional to view the requests and ensure that your token has been added appropriately.


## Using Gradle
- If you do not have Gradle already installed, follow the installation instructions [here](https://gradle.org/install/).
- Once Gradle is installed, run `gradle fatJar` from the installation directory using the command line.
- Make sure you are using the latest version of Gradle.

<!-- If no changes to the code are required, a prebuilt JAR file is available under Releases. It is preferable to compile your own JAR file. -->
