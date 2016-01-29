# fcrepo-user-webapp

User login/logout webapp for use alongside Fedora 4

## Usage

* `mvn clean package` to create `user.war`
* Place the `user.war` file in the Tomcat webapps directory
* Enable the [Tomcat Single Sign On valve](https://tomcat.apache.org/tomcat-7.0-doc/config/host.html#Single_Sign_On) in `$CATALINA_BASE/conf/server.xml`

## Description

Since Fedora 4 does no authentication of its own, this webapp provides a way for users to proactively authenticate themselves. Their user credentials are then passed to Fedora 4 using the Tomcat Single Sign On valve.

In combination with the [optional-authn-valve](https://github.com/umd-lib/optional-authn-valve), this allows for anonymous access to public resources within the repository while still allowing users to authenticate to access restricted resources.
