{% load static %}
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>{% block title %}My store{% endblock %}</title>
    <link href="{% static "css/base.css" %}" rel="stylesheet">
</head>
<body>
    <div id="header">
        <a href="/" class="logo">E-Booker</a>



    </div>
    <div id="subheader">
                <div class="top-nav-bar">
            {% if user.is_authenticated %}
                Hello, {{request.user.first_name}}! &nbsp; &nbsp; <a href="{% url "account:logout" %}">Logout&nbsp; &nbsp;</a>
            {% else %}
                Hello, Guest! &nbsp; &nbsp;
                <a href="{% url "account:login" %}">Login&nbsp; &nbsp;</a>
                <a href="{% url "account:signup" %}">Sign Up &nbsp; &nbsp;</a>
            {% endif %} 

            {% with total_items=cart|length %}
                {% if cart|length > 0 %}
                    Your cart: 
                    <a href="{% url "cart:cart_detail" %}">
                        {{ total_items }} item{{ total_items|pluralize }}, £{{ cart.get_total_price }}
                    </a>
                {% else %}
                    Your cart is empty.
                {% endif %}
            {% endwith %}
        <!-- </div> -->
        <!-- <div class="top-nav-bar"> -->
               
        </div>
    </div> 

    <div>



    <div id="content">
        {% block content %}
        {% endblock %}
    </div>
</body>
</html>