package com.yuyh.cavaliers.http.bean.match;

import com.yuyh.cavaliers.http.bean.base.Base;

import java.util.List;

/**
 * @author yuyh.
 * @date 16/7/2.
 */
public class MatchStat extends Base {

    public MatchStatInfo data;

    public static class MatchStatInfo {

        public String livePeriod;

        public MatchTeamInfo teamInfo;

        public static class MatchTeamInfo {
            public String leftId;
            public String leftName;
            public String leftBadge;
            public String leftGoal;
            public String leftUrl;
            public String rightId;
            public String rightName;
            public String rightBadge;
            public String rightGoal;
            public String rightUrl;
            public String quarterDesc;
        }

        public List<StatsBean> stats;

        public static class StatsBean {
            /**
             * type = 1  历史对阵
             * type = 2  近期战绩
             * type = 3  未来赛事
             * type = 12 比分
             * type = 13 球队数据王
             * type = 14 球队统计
             * type = 15 球员统计
             * type = 16 场上球员
             */
            public String type;
            public String text;

            public List<Goals> goals;                          // 比分

            public static class Goals {
                public List<String> head;
                public List<List<String>> rows;
            }

            public List<MaxPlayers> maxPlayers;                // 最佳球员

            public static class MaxPlayers {
                public String leftVal;
                public String rightVal;
                public MatchPlayerInfo leftPlayer;
                public MatchPlayerInfo rightPlayer;
                public String text;

                public static class MatchPlayerInfo {
                    public String playerId;
                    public String name;
                    public String icon;
                    public String position;
                    public String jerseyNum;
                    public String detailUrl;
                }
            }

            public List<VS> vs;                                 // 历史对阵

            public static class VS {
                public String matchId;
                public String startTime;
                public String leftName;
                public Integer leftGoal;
                public String leftBadge;
                public String leftUrl;
                public String rightName;
                public Integer rightGoal;
                public String rightBadge;
                public String rightUrl;
                public String matchDesc;
            }

            public TeamMatchs teamMatches;                      // 近期战绩 | 未来赛事

            public static class TeamMatchs {
                public List<TeamMatchsTeam> left;
                public List<TeamMatchsTeam> right;

                public static class TeamMatchsTeam {
                    public String startTime;
                    public String leftId;
                    public String leftName;
                    public Integer leftGoal;
                    public String leftBadge;
                    public String leftUrl;
                    public String rightId;
                    public Integer rightGoal;
                    public String rightName;
                    public String rightBadge;
                    public String rightUrl;
                    public String competitionName;
                }
            }


            //public PlayerStats playerStats;                      // 场上球员 | 球员技术统计

            public List<PlayerStats> playerStats;                // 球员技术统计
            public static class PlayerStats {

                // 场上球员
                public List<TeamBean> left;
                public List<TeamBean> right;

                public static class TeamBean {
                    public List<String> head;

                    public String playerId;
                    public String playerName;
                    public String playerIcon;
                    public String playerJerseyNum;
                    public String detailUrl;
                    public List<String> row;
                }

                // 技术统计
                public String subText;
                public List<String> head;
                public List<String> row;
                public String playerId;
                public String onCrt;
                public String started;
                public String detailUrl;
            }

            public List<TeamStats> teamStats;                     // 球队统计

            public static class TeamStats {
                public String text;
                public Integer leftVal;
                public Integer rightVal;
            }

        }

    }
}
