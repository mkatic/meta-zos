-- Standard awesome library
require("awful")
require("awful.autofocus")
require("awful.rules")
-- Theme handling library
require("beautiful")
-- Notification library
require("naughty")
require("cal")
require("obvious.popup_run_prompt")

-- {{{ Error handling
-- Check if awesome encountered an error during startup and fell back to
-- another config (This code will only ever execute for the fallback config)
if awesome.startup_errors then
    naughty.notify({ preset = naughty.config.presets.critical,
                     title = "Oops, there were errors during startup!",
                     text = awesome.startup_errors })
end

-- Handle runtime errors after startup
do
    local in_error = false
    awesome.add_signal("debug::error", function (err)
        -- Make sure we don't go into an endless error loop
        if in_error then return end
        in_error = true

        naughty.notify({ preset = naughty.config.presets.critical,
                         title = "Oops, an error happened!",
                         text = err })
        in_error = false
    end)
end
-- }}}

-- {{{ Variable definitions
-- Themes define colours, icons, and wallpapers
beautiful.init("/usr/share/awesome/themes/default/theme.lua")

-- This is used later as the default terminal and editor to run.
terminal = "mrxvt"
editor = os.getenv("EDITOR") or "vi"
editor_cmd = terminal .. " -e " .. editor

-- Default modkey.
-- Usually, Mod4 is the key with a logo between Control and Alt.
-- If you do not like this or do not have such a key,
-- I suggest you to remap Mod4 to another key using xmodmap or other tools.
-- However, you can use another modifier like Mod1, but it may interact with others.
modkey = "Mod4"

-- Table of layouts to cover with awful.layout.inc, order matters.
layouts =
{
    awful.layout.suit.max,
    awful.layout.suit.max.fullscreen,
}
-- }}}

-- {{{ Tags
tags = {}
tags[1] = awful.tag({ 1 }, s, layouts[1])
-- }}}

-- {{{ Menu
-- Create a laucher widget and a main menu
myawesomemenu = {
   { "edit config", editor_cmd .. " " .. awesome.conffile },
   { "restart", awesome.restart },
   { "quit", awesome.quit }
}

mymainmenu = awful.menu({ items = { { "awesome", myawesomemenu, beautiful.awesome_icon },
                                    { "open terminal", terminal }
                                  }
                        })

mylauncher = awful.widget.launcher({ image = image(beautiful.awesome_icon),
                                     menu = mymainmenu })
-- }}}
function notify_apm ()
	apm_string = awful.util.pread("apm")
	naughty.notify({title ="APM", text = apm_string, timeout=5})
end	

function read_apm ()
        local rv = {}
        local fd = io.popen("apm")
        if not fd then return end

        local data = fd:read("*all")
        if not data then return end

        rv.state  = data:match("battery ([a-z]+):")
        rv.charge = tonumber(data:match(".*, .*: (%d?%d?%d)%%"))
        fd:close()
	battery:set_value(rv.charge / 99)	
end

-- {{{ Wibox
-- Create a textclock widget
mytextclock = awful.widget.textclock({align = "right"}, "%H:%M") 
cal.register(mytextclock)

-- Create a systray
mysystray = widget({type = "systray" })

-- Create a wibox for each screen and add it
mywibox = {}
mytasklist = {}
mytasklist.buttons = awful.util.table.join(
			awful.button({ }, 1, function (c)
                                              if c == client.focus then
                                                  c.minimized = true
                                              else
                                                  if not c:isvisible() then
                                                      awful.tag.viewonly(c:tags()[1])
                                                  end
                                                  -- This will also un-minimize
                                                  -- the client, if needed
                                                  client.focus = c
                                                  c:raise()
                                              end
                                          end))
separator = widget ({type = "textbox"})
separator.text = " | "
s = 1

-- Create a tasklist widget
mytasklist[s] = awful.widget.tasklist(function(c)
		return awful.widget.tasklist.label.currenttags(c, s) end, mytasklist.buttons)

battery = awful.widget.progressbar()
battery:set_width(12)
battery:set_height(20)
battery:set_ticks(true)
battery:set_ticks_gap(1)
battery:set_ticks_size(2)
battery:set_vertical(true)
battery:set_border_color('#FFFFFF')
battery:set_background_color('#494B4F')
battery:set_color('#AECF96')
battery:set_gradient_colors({ '#AECF96', '#88A175', '#FF5656' })
battery.widget:buttons(awful.util.table.join(
		awful.button({}, 1, function() notify_apm() end)))

batt_timer = timer({timeout = 2})
batt_timer:add_signal("timeout", function () read_apm() end)
batt_timer:start()

-- Create the wibox
mywibox[s] = awful.wibox({ position = "bottom", screen = s })
-- Add widgets to the wibox - order matters
mywibox[s].widgets = {	
	mytextclock,
	separator,
	battery.widget,
	separator,
	mysystray,
	separator,
	mytasklist[s],
	layout = awful.widget.layout.horizontal.rightleft	
}

-- }}}

function maximise_windows()
	local clients = client.get()
	for n,client in pairs(clients) do
		client.minimized = false
	end	
end

function min_max_windows()
-- add a function that checks if only one client is maximised
	if all_minimised == true then
		minimise=false
		all_minimised = false
		all_maximised = true
	elseif all_maximised == true then
		minimise=true
		all_minimised = true
		all_maximised = false
	else 
		minimise=true
		all_minimised = true 
		all_maximised = false
	end

	local clients = client.get()
		for n,c in pairs(clients) do

			if not c.skip_taskbar then
				c.minimized = minimise
			end
		end
end

 obvious.popup_run_prompt.set_slide(true)	
-- {{{ Mouse bindings
root.buttons(awful.util.table.join(
    awful.button({ }, 3, function () mymainmenu:toggle() end),
    awful.button({ }, 4, awful.tag.viewnext),
    awful.button({ }, 5, awful.tag.viewprev)
))
-- }}}

-- {{{ Key bindings
globalkeys = awful.util.table.join(

-- focus window left

    awful.key({}, "XF86_Switch_VT_2",
        function ()
	   maximise_windows() 
           awful.client.focus.byidx( -1)
           if client.focus then client.focus:raise() end
        end),

-- focus window right

    awful.key({}, "XF86_Switch_VT_3",
        function ()
            maximise_windows()
            awful.client.focus.byidx(1)
            if client.focus then client.focus:raise() end
        end),

-- minimise/maximise all windows

  awful.key({}, "XF86_Switch_VT_5", min_max_windows),

awful.key ({}, "XF86_Switch_VT_4", function ()
			f_client = client.focus
			naughty.notify({text=f_client.name .." ".. f_client.class .." ".. tostring(f_client.type), title="", hover_timeout=3})
			end),

    awful.key({ modkey,           }, "w", function () mymainmenu:show({keygrabber=true, coords={x=0, y=0}}) end),

    -- Standard program
    awful.key({ modkey,           }, "Return", function () awful.util.spawn(terminal) end),
    awful.key({ modkey, "Control" }, "r", awesome.restart),
    awful.key({ modkey, "Shift"   }, "q", awesome.quit),

    awful.key({ modkey,           }, "space", function () awful.layout.inc(layouts,  1) end),
    awful.key({ modkey, "Shift"   }, "space", function () awful.layout.inc(layouts, -1) end),

    -- Prompt
    awful.key({ modkey },            "r", obvious.popup_run_prompt.run_prompt)
)

clientkeys = awful.util.table.join(
    awful.key({ modkey,           }, "f",      function (c) c.fullscreen = not c.fullscreen  end),
    awful.key({ modkey,	          }, "Escape",      function (c) c:kill()                         end),
    awful.key({ modkey,           }, "n",
        function (c)
            -- The client currently has the input focus, so it cannot be
            -- minimized, since minimized clients can't have the focus.
            c.minimized = true
        end)
)

clientbuttons = awful.util.table.join(
    awful.button({ }, 1, function (c) client.focus = c; c:raise() end),
    awful.button({ modkey }, 1, awful.mouse.client.move),
    awful.button({ modkey }, 3, awful.mouse.client.resize))

-- Set keys
root.keys(globalkeys)
-- }}}

-- {{{ Rules
awful.rules.rules = {
    -- All clients will match this rule.
    { rule = { },
      properties = { border_width = 0,
                     focus = true,
			size_hints_honor=false,
                     keys = clientkeys,
                     buttons = clientbuttons }}
}
-- }}}
function place_window (c)

--windows smaller than 2/3 of the screen are placed dead center
--windows larger than 2/3 are maximised

	if c.type == "desktop" then
		c.maximized_horizontal = true
		c.maximized_vertical = true
		return
	end

	two_thirds_screen = (480*640/3)*2
	client_geometry = c:geometry()
	client_size = client_geometry.width * client_geometry.height
	
	if client_size < two_thirds_screen then
		awful.placement.centered(c)
	else
		c.maximized_horizontal = true
		c.maximized_vertical = true
	end
end	
	
	
-- {{{ Signals
-- Signal function to execute when a new client appears.
client.add_signal("manage", function (c, startup)
	place_window(c)		
end)	
-- }}}
