SELECTED_OPTIMIZATION := "${@'${SELECTED_OPTIMIZATION}'.replace('-O2', '-O3')}"

EXTRA_OECONF += " --with-xinput=no"
