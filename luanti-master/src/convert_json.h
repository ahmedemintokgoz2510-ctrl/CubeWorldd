// CubeWorld
// SPDX-License-Identifier: LGPL-2.1-or-later
// Copyright (C) 2013 zodiac <celeron55@gmail.com>

#pragma once

#include <ostream>

namespace Json { class Value; }

void fastWriteJson(const Json::Value &value, std::ostream &to);

std::string fastWriteJson(const Json::Value &value);
